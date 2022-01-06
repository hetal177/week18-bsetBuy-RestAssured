package com.bestbuy.testbase.Categories;

import com.bestbuy.models.CategoriesPojo;
import com.bestbuy.testbase.testbase.CategoriesTestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPutRequest extends CategoriesTestBase {
    @Test
    public void PutRequestCategory(){
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setId("abcat0020002");
        categoriesPojo.setName("putTest_"+ TestUtils.getRandomText());

        Response response = given()
                .pathParam("id","abcat0020002")
                .contentType(ContentType.JSON)
                .body(categoriesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
