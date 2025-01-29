package requests;

import java.io.File;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

public class AuthRequest extends BaseRequest{
    
    @Step("(POST) Login Request")
    public void login(String filePath){
        Logs.info("(POST) Login Request");

        final Response response = getRequest()
            .basePath("auth/login")
            .body(new File(filePath))
            .request(Method.POST);

        ResponseManager.setResponse(response);
    }
}
