package listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import utilities.Logs;

public class SuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        Logs.info("Comenzando Suite: %s",suite.getName());
    }

    @Override
    public void onFinish(ISuite suite) {
        Logs.info("Finalizando Suite: %s",suite.getName());
    }
}
