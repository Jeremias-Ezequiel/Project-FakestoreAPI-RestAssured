package utilities;

import listeners.SuiteListener;
import listeners.TestListener;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({SuiteListener.class, TestListener.class})
public class BaseTest {
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected SoftAssert softAssert; 
    protected RequestManager requestManager = new RequestManager(); 

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        softAssert = new SoftAssert(); 
        requestManager.initRequest();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
    }
    
}
