package apis.products;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import models.product.PartialProduct;
import models.product.Product;
import models.product.ProductGetResponse;
import models.product.ProductPostResponse;
import requests.ProductsRequest;
import utilities.BaseTest;
import utilities.Logs;
import utilities.ResponseManager;

public class ProductsTests extends BaseTest {
    final ProductsRequest productsRequest = new ProductsRequest(); 

    @Test(groups = {"regression","smoke"})
    public void getAllProductsTest(){
        productsRequest.getProducts(); 
        
        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }
    
    @Test(groups = {"regression","smoke"})
    public void getSingleProducTest(){
        String pathSchema = "src/test/resources/schemas/ProductSchema.json";
        productsRequest.singleProduct(1);
        final ProductGetResponse response = ResponseManager.getResponseBody(ProductGetResponse.class); 

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
        ResponseManager.doSchemaValidation(pathSchema);
        
        softAssert.assertNotNull(response.id()); 
        softAssert.assertTrue(response.price() > 0);
        softAssert.assertFalse(response.title().isEmpty());
        softAssert.assertAll();
    }

    @Test
    public void getALimitOfResultsTest(){
        final Map<String,String> queryMap = Map.of(
            "limit","10"
        ); 
        productsRequest.limitResultsProduct(queryMap);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
        List<ProductGetResponse> list = ResponseManager.getResponseBodyAsList(); 

        ResponseManager.verifyLengthList(queryMap.get("limit"), list);
    }

    @Test(groups = {"regression"})
    public void sortResultsTest(){
        final Map<String,String> queryMap = Map.of(
            "sort","desc"
        ); 
        productsRequest.sortproducts(queryMap);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test(groups = {"regression","smoke"})
    public void getAllCategoriesTest(){
        productsRequest.getAllCategories(); 
        
        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test(groups = {"regression"})
    public void getSpecificCategoryTest(){
        productsRequest.getProductsInCategory("jewerly");   

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test(groups = {"regression","smoke"})
    public void addNewProducTest(){
        final Product newProduct = Product.generateProduct(); 
        productsRequest.addProduct(newProduct);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200); 

        final ProductPostResponse responseBody = ResponseManager.getResponseBody(ProductPostResponse.class); 

        softAssert.assertTrue(responseBody.id() > 0);
    }

    @Test(groups = {"regression","smoke"})
    public void updateProductTest(){
        final Product newProduct = Product.generateProduct(); 
        int idProduct = 3; 
        productsRequest.updateProduct(idProduct,newProduct); 

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }

    @Test(groups = {"regression","smoke"})
    public void updatePartialProductTest(){
        final PartialProduct partialProduct = PartialProduct.generatePartialProduct(); 
        softAssert.assertTrue(partialProduct.isValid(),"The Partial Product must have at least one non-null field");
        
        productsRequest.partialProduct(4, partialProduct);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);

        softAssert.assertAll();
    }

    @Test(groups = {"regression","smoke"})
    public void deleteProductTest(){
        productsRequest.deleteProduct(3);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(200);
    }
}
