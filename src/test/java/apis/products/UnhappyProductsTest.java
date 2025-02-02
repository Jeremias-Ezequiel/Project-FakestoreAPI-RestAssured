package apis.products;

import org.testng.annotations.Test;

import requests.ProductsRequest;
import utilities.BaseTest;
import utilities.ResponseManager;

public class UnhappyProductsTest extends BaseTest{
    final ProductsRequest productsRequest = new ProductsRequest(); 

    @Test(groups = {"regression","smoke"})
    public void getSingleProductTest(){
        productsRequest.singleProduct(123123);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(404);
    }
}
