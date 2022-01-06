package com.bestbuy.testbase.Stores;

import com.bestbuy.testbase.testbase.StoresTestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoreDeleteTest extends StoresTestBase {



        @Test
        public void deleteSingleStoreData(){
            Response response = given()
                    .pathParam("id", "7")
                    .when()
                    .delete("/{id}");
            response.then().statusCode(200);
            response.prettyPrint();
        }


    }
