package com.bestbuy.testbase.Stores;

import com.bestbuy.testbase.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresGetRequest extends StoresTestBase {

    @Test
    public void getAllStoresList(){
        Response response = given()
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
