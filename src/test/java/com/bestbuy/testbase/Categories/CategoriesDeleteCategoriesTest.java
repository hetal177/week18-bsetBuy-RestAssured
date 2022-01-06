package com.bestbuy.testbase.Categories;

import com.bestbuy.testbase.testbase.CategoriesTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteCategoriesTest extends CategoriesTestBase {

    @Test
    public void deleteACategory(){
        Response response = given()
                .pathParam("id", "abcat0020001")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}


