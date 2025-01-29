package apis.auth;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import dev.failsafe.internal.util.Assert;
import models.auth.LoginResponse;
import requests.AuthRequest;
import utilities.BaseTest;
import utilities.Logs;
import utilities.ResponseManager;

public class AuthTests extends BaseTest{
    private AuthRequest authRequest = new AuthRequest(); 

    @Test
    public void loginTest(){
        final String path = "src/test/resources/requestBody/login.json"; 
        authRequest.login(path);

        ResponseManager.verifyStatusCode(200);
        // ResponseManager.verifyResponseTime(1000);
        LoginResponse loginResponse = ResponseManager.getResponseBody(LoginResponse.class);

        softAssert.assertEquals(loginResponse.token().length(), 140,"The length of the response is not match with a 23 characters");
        softAssert.assertAll();
    }
}
