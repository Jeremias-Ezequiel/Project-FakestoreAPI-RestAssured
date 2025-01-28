package utilities;

import java.io.File;

import org.testng.Assert;

import io.qameta.allure.Step;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class ResponseManager {
    private static Response response; 

    public static void setResponse(Response response){
        ResponseManager.response = response; 
    }

    @Step("Verificando el status code")
    public static void verifyStatusCode(int expectedStatusCode){
        Logs.info("Verificando el status code");
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    @Step("Verificando el response time")
    public static void verifyResponseTime(int maxResponseTime){
        Logs.info("Verificando el response time");
        Assert.assertTrue(response.getTime() < maxResponseTime,String.format("The status code is: %s, the status code expected is: %s", response.getTime(),maxResponseTime));
    }

    @Step("Haciendo el Schema Validation")
    public static void doSchemaValidation(String schemaPath){
        Logs.info("Haciendo el Schema Validation");
        response 
            .then() 
            .body(JsonSchemaValidator.matchesJsonSchema(new File(schemaPath))); 
    }

    public static <T> T getResponseBody(Class <T> clazz){
        return response.body().as(clazz); 
    }

    public static String getPathAsString(String path){
        return response.path(path).toString(); 
    }
}
