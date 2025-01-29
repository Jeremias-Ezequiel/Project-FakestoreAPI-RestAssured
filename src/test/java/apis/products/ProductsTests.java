package apis.products;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import models.product.Product;
import models.product.ProductResponse;
import requests.ProductsRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class ProductsTests extends BaseTest {
    final ProductsRequest productsRequest = new ProductsRequest(); 

    @Test
    public void getAllProductsTest(){
        productsRequest.getProducts(); 
        
        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }
    
    @Test
    public void getSingleProducTest(){
        String pathSchema = "src/test/resources/schemas/ProductSchema.json";
        productsRequest.singleProduct(1);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
        ResponseManager.doSchemaValidation(pathSchema);
    }

    @Test
    public void getALimitOfResultsTest(){
        final Map<String,String> queryMap = Map.of(
            "limit","3"
        ); 
        productsRequest.limitResultsProduct(queryMap);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test
    public void sortResultsTest(){
        final Map<String,String> queryMap = Map.of(
            "sort","desc"
        ); 
        productsRequest.sortproducts(queryMap);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test
    public void getAllCategoriesTest(){
        productsRequest.getAllCategories(); 
        
        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test
    public void getSpecificCategoryTest(){
        productsRequest.getProductsInCategory("jewerly");   

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test
    public void addNewProducTest(){
        final Product newProduct = Product.generateProduct(); 
        productsRequest.addProduct(newProduct);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200); 

        final ProductResponse responseBody = ResponseManager.getResponseBody(ProductResponse.class); 

        softAssert.assertTrue(responseBody.id() > 0);
    }
}
