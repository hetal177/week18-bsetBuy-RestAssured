package com.bestbuy.testbase.products;

import com.bestbuy.models.ProductsPojo;
import com.bestbuy.testbase.testbase.ProductsTestBase;
import com.bestbuy.utils.TestUtils;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * @author Vimal Vithalpura
 * @project BestBuy-API-RestAssured-HW18
 * @created 03/01/2022
 */
public class ProductsCRUDTest extends ProductsTestBase {

    static String name = "Apple HomePod Mini ";
    static String type = "HardGood";
    static int price = 99;
    static int shipping = 10;
    static String upc = "123433429874";
    static String description = "Apple HomePod Mini Smart Speaker with Siri";
    static String manufacturer = "Apple";
    static String model = "HomePod Mini";
    static String url = TestUtils.getRandomText();
    static String image = TestUtils.getRandomText();
    static int productId;

    // Create new store with - POST
    @Test
    public void test001() {
        ProductsPojo productPojo = new ProductsPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

    // Extract productId of newly created product
    @Test
    public void test002() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        HashMap value = given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .path(p1 + name + p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
        productId = (int) value.get("id");
    }

    // Update product record with PUT
    @Test
    public void test003() {
        String p1 = "data.findAll{it.name='";
        String p2 = "'}.get(0)";

        name = name + " (Updated)";
        description = description + " (Updated)";

        ProductsPojo productPojo = new ProductsPojo();
        productPojo.setName(name);
        productPojo.setType(type);
        productPojo.setPrice(price);
        productPojo.setShipping(shipping);
        productPojo.setUpc(upc);
        productPojo.setDescription(description);
        productPojo.setManufacturer(manufacturer);
        productPojo.setModel(model);
        productPojo.setUrl(url);
        productPojo.setImage(image);

        given()
                .header("Content-Type", "application/json")
                .pathParam("productId", productId)
                .body(productPojo)
                .when()
                .put("/{productId}")
                .then().log().all().statusCode(200);

        // Assert response with 'id' after extracting by 'name'
        HashMap<String, Object> value =
                given()
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .path(p1 + name+p2);
        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(value));
    }

    // Delete record with - DELETE
    @Test
    public void test004(){

        given()
                .pathParam("productId", productId)
                .when()
                .delete("/{productId}")
                .then()
                .statusCode(200);
        given()
                .pathParam("productId", productId)
                .when()
                .delete("/{productId}")
                .then()
                .statusCode(404);
    }

}
