package data;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
    public static final String ERROR_ID_DP = "ErrorIdIndex"; 

    @DataProvider(name = ERROR_ID_DP)
    public Object[][] errorIdIndex(){
        return new Object[][]{
            {-1,400},
            {123123123,404},
            {0,404}
        };
    }
}
