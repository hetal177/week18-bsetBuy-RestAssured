package com.bestbuy.testbase.Stores;

import com.bestbuy.models.StorePojo;
import com.bestbuy.testbase.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPut extends StoresTestBase {

    @Test
    public void updateStoreDataWithPut(){
       StorePojo storePojo = new StorePojo();
        storePojo.setName("London");
        storePojo.setType("Metro");
        storePojo.setAddress("12,crowly lane");
        storePojo.setAddress2("London Road");
        storePojo.setCity("Ean");
        storePojo.setState("Sussex");
        storePojo.setZip("11022");
        storePojo.setLat(44.96900);
        storePojo.setLng(-93.449231);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun:12-8");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id","7")
                .body(storePojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
