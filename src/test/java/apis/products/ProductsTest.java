package apis.products;

import org.testng.annotations.Test;
import requests.ProductsRequests;
import utilities.BaseTest;
import utilities.ResponseManager;

public class ProductsTest extends BaseTest{
    private ProductsRequests productsRequests = new ProductsRequests();

    @Test
    public void getAllUsers(){
        productsRequests.getAllProductsTest();

        ResponseManager.verifyStatusCode(200);
    }
}
