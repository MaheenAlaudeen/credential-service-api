/*
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 */

package com.dell.cpsd.service.rcm;

import org.junit.Ignore;
import org.junit.Test;

import static com.dell.cpsd.common.json.utils.JsonSchemaValidation.validateSchema;
import static org.junit.Assert.assertNull;

/**
 * Validate if example files are correct.<br/>
 * Test goal in &lt;packaging&gt;pom&lt;/packaging&gt; is not triggered automatically,
 * you can run this test manually in IDE to validate schema/example consistency.
 * <p>
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 * </p>
 *
 * @version 1.0
 * @since SINCE-TBD
 */
public class ValidateExamplesTest
{
    public static final String SCHEMA_DIR  = "/credentials-service-api/schema/json/";
    public static final String EXAMPLE_DIR = "/credentials-service-api/schema/example/json/";
    public static final String INCLUDES_DIR = SCHEMA_DIR;
    public static final String REQUEST     = "request";
    public static final String RESPONSE    = "response";
    public static final String ERROR       = "error";

    @Test
    public void componentCredentialsWriteRequest() throws Exception
    {
        String messageName = "/ComponentCredentialsWriteRequest";
        String errors = validateSchema(SCHEMA_DIR + REQUEST + messageName + ".jsd", EXAMPLE_DIR + REQUEST + messageName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void componentCredentialsReadRequest() throws Exception
    {
        String messageName = "/ComponentCredentialsReadRequest";
        String errors = validateSchema(SCHEMA_DIR + REQUEST + messageName + ".jsd", EXAMPLE_DIR + REQUEST + messageName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void componentCredentialsResponse() throws Exception
    {
        String messageName = "/ComponentCredentialsResponse";
        String errors = validateSchema(SCHEMA_DIR + RESPONSE + messageName + ".jsd", EXAMPLE_DIR + RESPONSE + messageName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

    @Test
    public void errorMessage() throws Exception
    {
        String messageName = "/CredentialServiceErrorMessage";
        String errors = validateSchema(SCHEMA_DIR + ERROR + messageName + ".jsd", EXAMPLE_DIR + ERROR + messageName + ".json", INCLUDES_DIR);
        assertNull(errors, errors);
    }

}
