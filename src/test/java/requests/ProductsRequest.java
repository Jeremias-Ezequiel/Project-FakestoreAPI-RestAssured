package requests;

import java.util.Map;

import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import models.product.PartialProduct;
import models.product.Product;
import utilities.BaseRequest;
import utilities.Logs;
import utilities.ResponseManager;

public class ProductsRequest extends BaseRequest{

    @Step("(GET) All products")
    public void getProducts(){
        Logs.info("(GET) All products");
        final var response = getRequest()
            .basePath("products")
            .request(Method.GET);
        ResponseManager.setResponse(response);
    }

    @Step("(GET) Single product")
    public void singleProduct(int id){
        Logs.info("(GET) Single product");

        final Response response = getRequest()
            .basePath("products/{paramId}")
            .pathParam("paramId", id)
            .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) Product result limit")
    public void limitResultsProduct(Map<String,String> queryMap){
        Logs.info("(GET) Product result limit");

        final Response response = getRequest()
            .basePath("products")
            .queryParams(queryMap)
            .request(Method.GET);
        
        ResponseManager.setResponse(response);
    }

    @Step("(GET) Product results sort")
    public void sortproducts(Map<String,String> queryMap){
        Logs.info("(GET) Product results sort");

        final Response response = getRequest()
            .basePath("products")
            .queryParams(queryMap)
            .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) All categories")
    public void getAllCategories(){
        Logs.info("(GET) All categories");

        final Response response = getRequest()
            .basePath("products/categories")
            .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(GET) Get products in a specific category")
    public void getProductsInCategory(String category){
        Logs.info("(GET) Get products in a specific category");

        final Response response = getRequest()
            .basePath("products/category/{categori}")
            .pathParam("categori", category)
            .request(Method.GET);

        ResponseManager.setResponse(response);
    }

    @Step("(POST) Create a new product")
    public void addProduct(Product product){
        Logs.info("(POST) Create a new product");
        
        final Response response = getRequest()
            .basePath("products")
            .body(product)
            .request(Method.POST);

        ResponseManager.setResponse(response);
    }

    @Step("(PUT) Update a product")
    public void updateProduct(int id, Product product){
        Logs.info("(PUT) Update a product");

        final Response response = getRequest()
            .basePath("products/{id}")
            .pathParam("id", id)
            .body(product)
            .request(Method.PUT); 

        ResponseManager.setResponse(response);
    }

    @Step("(PATCH) Update a partial product")
    public void partialProduct(int id, PartialProduct partialProduct){
        Logs.info("(PATCH) Update a partial product");
        
        final Response response = getRequest()
            .basePath("products/{index}")
            .pathParam("index", id)
            .body(partialProduct)
            .request(Method.PATCH); 
        
        ResponseManager.setResponse(response);
    }

    @Step("(DELETE) Delete a product")
    public void deleteProduct(int index){
        Logs.info("(DELETE) Delete a product");

        final Response response = getRequest()
            .basePath("/products/{id}")
            .pathParam("id", index)
            .request(Method.DELETE); 

        ResponseManager.setResponse(response);
    }

}
