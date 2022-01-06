package com.bestbuy.testbase.Categories;

import com.bestbuy.models.CategoriesPojo;
import com.bestbuy.testbase.testbase.CategoriesTestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostRequest extends CategoriesTestBase {

    @Test
    public void creatingNewCategory(){
        CategoriesPojo categoriesPojo=new CategoriesPojo();
        categoriesPojo.setId("postCategories-001" + TestUtils.getRandomValue());
        categoriesPojo.setName("PostCategoryAdded"+TestUtils.getRandomText());
        Response response = given()
                .contentType(ContentType.JSON)
                //not working("application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
    }


