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
public class ProductsPostTest extends ProductsTestBase {

    @Test
    public void createNewProduct(){

        ProductsPojo productPojo = new ProductsPojo();
        productPojo.setName("Apple iPad pro 512 GB");
        productPojo.setType("HardGood");
        productPojo.setPrice(899);
        productPojo.setShipping(20);
        productPojo.setUpc("123433429874");
        productPojo.setDescription("Apple iPad pro 512GB - Silver");
        productPojo.setManufacturer("Apple");
        productPojo.setModel("iPad");
        productPojo.setUrl("This is url for iPad Pro");
        productPojo.setImage("This is image for iPad Pro");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }
}

/*
9999685 - iphone
9999687 - ipad
9999688 - ipad 1tb
 */