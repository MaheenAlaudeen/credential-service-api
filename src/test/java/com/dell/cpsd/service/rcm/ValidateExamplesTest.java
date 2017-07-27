/*
 * &copy; 2016 VCE Company, LLC. All rights reserved.
 * VCE Confidential/Proprietary Information
 */

package com.dell.cpsd.service.rcm;

import org.junit.Ignore;
import org.junit.Test;

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
    public static final String SCHEMA_DIR  = "/credential-service-api/schema/json/";
    public static final String EXAMPLE_DIR = "/credential-service-api/schema/example/json/";
    public static final String REQUEST     = "request";
    public static final String RESPONSE    = "response";
    public static final String ERROR       = "error";

    @Test
    @Ignore
    public void componentCredentialsWriteRequest() throws Exception
    {
        String messageName = "/ComponentCredentialsWriteRequest";
        JsonSchemaUtil.validateSchema(SCHEMA_DIR + REQUEST + messageName + ".jsd", EXAMPLE_DIR + REQUEST + messageName + ".json");
    }

    @Test
    @Ignore
    public void componentCredentialsReadRequest() throws Exception
    {
        String messageName = "/ComponentCredentialsReadRequest";
        JsonSchemaUtil.validateSchema(SCHEMA_DIR + REQUEST + messageName + ".jsd", EXAMPLE_DIR + REQUEST + messageName + ".json");
    }

    @Test
    public void componentCredentialsResponse() throws Exception
    {
        String messageName = "/ComponentCredentialsResponse";
        JsonSchemaUtil.validateSchema(SCHEMA_DIR + RESPONSE + messageName + ".jsd", EXAMPLE_DIR + RESPONSE + messageName + ".json");
    }

    @Test
    @Ignore
    public void errorMessage() throws Exception
    {
        String messageName = "/CredentialServiceErrorMessage";
        JsonSchemaUtil.validateSchema(SCHEMA_DIR + ERROR + messageName + ".jsd", EXAMPLE_DIR + messageName + ".json");
    }

}
