package requests;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.BaseRequest;
import utilities.ResponseManager;

public class ProductsRequests extends BaseRequest{

    @Step("(GET) Get all products")
    public void getAllProductsTest(){
        Response response = getRequest()
            .basePath("products")
            .request(Method.GET);
        
        ResponseManager.setResponse(response);
    }
}
