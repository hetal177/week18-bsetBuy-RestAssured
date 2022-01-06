package com.bestbuy.testbase.Categories;

import com.bestbuy.testbase.testbase.CategoriesTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesGetRequests extends CategoriesTestBase {
    @Test

    public void getAllCategoriesInfo() {
        Response response = given()
                .when()
              //  .get("/categories");
        .get();
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentsInfo() {
        Response response = given()
                //.queryParam("id", "abcat0100000")
                .pathParam("id", "abcat0020002")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getAllCategoriesWithName() {
        Response response = given()
                .queryParam("name", "Unique Gifts")
                .when()
                .get();
        response.then().statusCode(200);
        response.prettyPrint();
    }



    }

