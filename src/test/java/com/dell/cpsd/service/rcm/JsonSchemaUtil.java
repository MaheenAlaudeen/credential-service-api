/*
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 */

package com.dell.cpsd.service.rcm;

import org.everit.json.schema.Schema;
import org.everit.json.schema.SchemaException;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.fail;

/**
 * JSON schema utils.
 * <p>
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since SINCE-TBD
 */
public final class JsonSchemaUtil
{
    private JsonSchemaUtil()
    {
        //Utility class
    }

    /**
     * Validate JSON message against schema definition.
     *
     * @param schemaResourcePath absolute path to schema resource
     * @param jsonResourcePath   absolute path to message example resource
     * @since SINCE-TBD
     */
    public static void validateSchema(String schemaResourcePath, String jsonResourcePath)
    {
        try (final InputStream streamSchema = JsonSchemaUtil.class.getResourceAsStream(schemaResourcePath);
                final InputStream streamExample = JsonSchemaUtil.class.getResourceAsStream(jsonResourcePath))
        {
            if (streamSchema == null)
            {
                fail("Schema reading failed for: " + schemaResourcePath);
            }
            if (streamExample == null)
            {
                fail("Example reading failed for: " + jsonResourcePath);
            }
            validateSchema(streamSchema, streamExample);
        }
        catch (IOException e)
        {
            fail(e.getMessage() + "\n" + schemaResourcePath + "\n" + jsonResourcePath);
        }
    }

    /**
     * Validate JSON message against schema definition.
     *
     * @param streamSchema  schema InputStream
     * @param streamExample message example InputStream
     * @since SINCE-TBD
     */
    public static void validateSchema(InputStream streamSchema, InputStream streamExample)
    {
        final JSONTokener schemaTokener = new JSONTokener(streamSchema);
        final JSONObject rawSchema = new JSONObject(schemaTokener);
        final Schema schema;
        try
        {
            SchemaLoader schemaLoader = SchemaLoader.builder().schemaJson(rawSchema).resolutionScope("/credential-service-api/schema/json/")
                    .httpClient(new org.everit.json.schema.loader.internal.DefaultSchemaClient()).build();
            schema = schemaLoader.load(rawSchema);
        }
        catch (SchemaException e)
        {
            System.err.println("Schema loading error");
            e.printStackTrace();
            fail(e.getMessage());
            return;
        }
        try
        {
            final JSONTokener messageTokener = new JSONTokener(streamExample);
            final JSONObject messageObject = new JSONObject(messageTokener);
            schema.validate(messageObject);
        }
        catch (ValidationException e)
        {
            System.err.println("Schema: " + schema.getTitle() + " / " + schema.getDescription());
            e.getCausingExceptions().stream().map(ValidationException::getMessage).forEach(System.out::println);
            fail(e.getMessage());
        }
        catch (JSONException e)
        {
            System.err.println("Schema: " + schema.getTitle() + " / " + schema.getDescription());
            fail(e.getMessage());
        }
    }
}
