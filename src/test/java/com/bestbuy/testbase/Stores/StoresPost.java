package com.bestbuy.testbase.Stores;

import com.bestbuy.models.StorePojo;
import com.bestbuy.testbase.testbase.StoresTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPost extends StoresTestBase {
    @Test
    public void AddNewStore() {
        StorePojo storePojo = new StorePojo();
        storePojo.setName("Ryners");
        storePojo.setType("Local");
        storePojo.setAddress("205,ray lane");
        storePojo.setAddress2("ram avenue");
        storePojo.setCity("Mopkins");
        storePojo.setState("MN");
        storePojo.setZip("12345");
        storePojo.setLat(52.969658);
        storePojo.setLng(90.449539);
        storePojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");

        Response response = given()
                .contentType(ContentType.JSON)
                .body(storePojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
