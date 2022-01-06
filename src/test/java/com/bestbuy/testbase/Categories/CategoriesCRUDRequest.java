package com.bestbuy.testbase.Categories;

import com.bestbuy.models.CategoriesPojo;
import com.bestbuy.testbase.testbase.CategoriesTestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import com.google.gson.GsonBuilder;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CategoriesCRUDRequest extends CategoriesTestBase {

    static String name = "Computers and Electronics";
    static String id = "CURD_" + TestUtils.getRandomText();
    static String categoryId;

    @Test
    public void test001() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void test002() {

        //to fet id from  name entered by randam method("CURD_" + TestUtils.getRandomText();) so
        //so we can use that id in next method
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";
//you can do category ID - using >>>categoryId = (String) value.get("id");

        HashMap<String, Object> value =
                         given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name + p2);
        System.out.println(value);
     //   System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
        //get category id
        categoryId = (String) value.get("id");
    }

    @Test
    public void test003() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";
        name = name + "(Updated)";
        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName(name);
        categoriesPojo.setId(id);

        Response response = given()
                .contentType(ContentType.JSON)
               // .header("Content-Type", "application/json")
                .pathParam("categoryId", categoryId)
                .body(categoriesPojo)
                .when()
                .put("/{categoryId}");
        response.then().statusCode(200);
        response.prettyPrint();
        HashMap<String, Object> value = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        System.out.println((new GsonBuilder()).setPrettyPrinting().create().toJson(value));
    }
    @Test
    public void test004(){

        given()
                .pathParam("categoryId", categoryId)
                .when()
                .delete("/{categoryId}")
                .then()
                .statusCode(200);

        given()
                .pathParam("categoryId", categoryId)
                .when()
                .get("/{categoryId}")
                .then()
                .statusCode(404);
    }
}