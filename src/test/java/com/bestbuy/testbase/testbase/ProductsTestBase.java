package com.bestbuy.testbase.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class ProductsTestBase {
    @BeforeClass
    public static void inIt() {

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        RestAssured.basePath="/products";
    }
}
