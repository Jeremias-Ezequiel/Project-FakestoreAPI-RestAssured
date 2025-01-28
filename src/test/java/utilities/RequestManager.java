package utilities;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import requests.AuthRequest;

public class RequestManager {
    
    public void initRequest(){
        Logs.debug("Creando el request");
        final var request = RestAssured.given().spec(buildRequestSpec()); 
    
        Logs.debug("Guardando el request en el Request Provider");
        new RequestProvider().set(request);
    }

    public RequestSpecification buildRequestSpec(){
        return new RequestSpecBuilder()
            .addFilter(new RequestFilter())
            .setBaseUri("https://fakestoreapi.com")
            .setContentType(ContentType.JSON)
            .build(); 
    }

    @Step("Autenticandose con el request de login")
    public void initAuth(){
        Logs.info("Autenticandose con el request de login");
        final var authRequest = new AuthRequest();
        authRequest.login("src/test/resources/requestBody/login.json"); // Credentials 
        final var token = ResponseManager.getPathAsString("token"); 
        
        new RequestProvider().get().auth().preemptive().oauth2(token); 
    }

}
