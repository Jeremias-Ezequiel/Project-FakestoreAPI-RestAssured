package data;

import org.testng.annotations.DataProvider;

public class AuthDataProvider {
    public static final String ERROR_CREDENTIALS_AUTH_DP = "ErrorCredentialsAuth"; 

    @DataProvider(name = ERROR_CREDENTIALS_AUTH_DP)
    public Object[][] errorCredentialsDP(){
        final String templatePath = "src/test/resources/requestBody/auth/%s.json";
    
        return new Object[][]{
            {String.format(templatePath,"emptyCredentials"),400},
            {String.format(templatePath,"invalidCredentials"),401}
        };
    }
}
