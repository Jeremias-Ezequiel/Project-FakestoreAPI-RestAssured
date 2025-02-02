package apis.auth;

import org.testng.annotations.Test;

import data.AuthDataProvider;
import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyAuthTests extends BaseTest{
    AuthRequest authRequest = new AuthRequest(); 

    @Test(
        groups = {"regression","smkoe"},
        dataProvider = AuthDataProvider.ERROR_CREDENTIALS_AUTH_DP,
        dataProviderClass = AuthDataProvider.class
    )
    public void errorCredentialsTest(String path, int statusCode){
        authRequest.login(path); 

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(statusCode);
    }
}
