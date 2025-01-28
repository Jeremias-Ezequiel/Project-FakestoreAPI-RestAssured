package apis.auth;

import org.testng.annotations.Test;

import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class AuthTests extends BaseTest{
    private AuthRequest authRequest = new AuthRequest(); 

    @Test
    public void loginTest(){
        final String path = "src/test/resources/requestBody/login.json"; 
        authRequest.login(path);

        ResponseManager.verifyStatusCode(200);
        ResponseManager.verifyResponseTime(1000);
    }
}
