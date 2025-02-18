package apis.products;

import org.testng.annotations.Test;

import data.CustomDataProvider;
import models.product.Product;
import requests.ProductsRequest;
import utilities.BaseTest;
import utilities.Logs;
import utilities.ResponseManager;

public class UnhappyProductsTest extends BaseTest{
    final ProductsRequest productsRequest = new ProductsRequest(); 

    @Test(
        groups = {"regression","smoke"},
        dataProvider = CustomDataProvider.ERROR_ID_DP,
        dataProviderClass = CustomDataProvider.class
    )
    public void getSingleProductTest(int id, int statusCode){
        productsRequest.singleProduct(id);

        // ResponseManager.verifyResponseTime(1000);
        ResponseManager.verifyStatusCode(statusCode);
    }

    @Test(
        groups = {"regression","smoke"},
        dataProvider = CustomDataProvider.ERROR_ID_DP,
        dataProviderClass = CustomDataProvider.class
    )
    public void deleteInvalidProductTest(int id, int statusCode){
        productsRequest.deleteProduct(id);

        ResponseManager.verifyStatusCode(statusCode);
    }

    @Test(
        groups = {"regression"},
        dataProvider = CustomDataProvider.ERROR_ID_DP,
        dataProviderClass = CustomDataProvider.class
    )
    public void updateInvalidProducTest(int id, int statusCode){
        final Product product = Product.generateProduct(); 
        productsRequest.updateProduct(id, product);

        ResponseManager.verifyStatusCode(statusCode);
    }  

    @Test(groups = {"regression","smoke"})
    public void invalidCategory(){
        productsRequest.getProductsInCategory("clothes");

        ResponseManager.verifyStatusCode(404);
    }
}
