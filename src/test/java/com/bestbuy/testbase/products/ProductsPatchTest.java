package com.bestbuy.testbase.products;

import com.bestbuy.models.ProductsPojo;
import com.bestbuy.testbase.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Vimal Vithalpura
 * @project BestBuy-API-RestAssured-HW18
 * @created 02/01/2022
 */
public class ProductsPatchTest extends ProductsTestBase {

    @Test
    public void updateProductWithPatch() {
        ProductsPojo productPojo = new ProductsPojo();
        productPojo.setName("Apple iPad pro 1 TB");
        productPojo.setType("HardGood");
        productPojo.setPrice(899);
        productPojo.setShipping(0);
        productPojo.setUpc("456733429874");
        productPojo.setDescription("Apple iPad pro 1TB - Silver");
        productPojo.setManufacturer("Apple");
        productPojo.setModel("iPad");
        productPojo.setUrl("This is url for iPad Pro 1 TB");
        productPojo.setImage("This is image for iPad Pro 1 TB");

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", "9999687")
                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
