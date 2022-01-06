package com.bestbuy.testbase.products;

import com.bestbuy.testbase.testbase.ProductsTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

/**
 * @author Vimal Vithalpura
 * @project BestBuy-API-RestAssured-HW18
 * @created 02/01/2022
 */
public class ProductsDeleteTest extends ProductsTestBase {

    @Test
    public void deleteSingleProduct() {
        Response response = given()
                .pathParam("id", "9999687")
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


}
