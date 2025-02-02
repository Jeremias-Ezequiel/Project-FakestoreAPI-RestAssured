package apis.auth;

import org.testng.annotations.Test;

import data.CustomDataProvider;
import requests.AuthRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyAuthTests extends BaseTest{
    AuthRequest authRequest = new AuthRequest(); 

    @Test(
        groups = {"regression","smkoe"},
        dataProvider = CustomDataProvider.ERROR_CREDENTIALS_AUTH_DP,
        dataProviderClass = CustomDataProvider.class
    )
    public void errorCredentialsTest(String path, int statusCode){
        authRequest.login(path); 

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(statusCode);
    }
}
