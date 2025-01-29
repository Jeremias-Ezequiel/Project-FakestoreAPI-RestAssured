package apis.auth;

import org.testng.annotations.Test;

import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyAuthTests extends BaseTest{
    AuthRequest authRequest = new AuthRequest(); 

    @Test
    public void emptyCredentialsTest(){
        String pathCredentials = "src/test/resources/requestBody/emptyCredentials.json"; 

        authRequest.login(pathCredentials);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(400);
    }

    @Test
    public void invalidCredentialsTest(){
        String pathCredentials = "src/test/resources/requestBody/invalidCredentials.json";

        authRequest.login(pathCredentials);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(401);
    }

}
