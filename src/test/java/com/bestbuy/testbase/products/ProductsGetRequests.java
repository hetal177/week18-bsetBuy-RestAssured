package com.bestbuy.testbase.products;

import com.bestbuy.testbase.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProductsGetRequests extends ProductsTestBase {


    @Test
    public void getAllProducts() {
        Response response = given()
                .when()
                .get();
        response.then()
                .statusCode(200);
        response.prettyPrint();

    }

    // with Hashmap
    @Test
    public void getProductsTypenPriceToResult() {
        HashMap<String, Object> qParams = new HashMap<>();
        //  qParams.put("limit", "2");
        qParams.put("type", "HardGood");
        qParams.put("price", "5.49");
        Response response = given()
                .queryParams(qParams)
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getProductsByModel() {
        Response response = given()
              .pathParam("model", "MN1500B4Z")
                .when()
                .get("/{model}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}



