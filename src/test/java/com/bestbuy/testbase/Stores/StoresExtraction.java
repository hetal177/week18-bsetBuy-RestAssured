package com.bestbuy.testbase.Stores;

import com.bestbuy.testbase.testbase.StoresTestBase;
import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtraction extends StoresTestBase {

    static ValidatableResponse response;

    @Before
    public void getValidatableResponse() {
        response = given()
                .when()
                .get()
                .then().statusCode(200);
    }

    @Test
    public void test001() {
        //Extract the limit
        int limit = response.extract().path("limit");
        System.out.println("Extract the limit");
        System.out.println("The limit is " + limit);
        System.out.println("**************************************************************");
    }

    @Test
    public void test002() {
        //Extract the total
        int total = response.extract().path("total");
        System.out.println(" Extract the total");
        System.out.println("The total is " + total);
        System.out.println("**************************************************************");

    }

    @Test
    public void test003() {
        //Extract the name of 5th store
        // ... ??  List<String> storename = response.extract().path("data[4].name");
        List<String> name = response.extract().path("data.findAll{it.id == 4}.name");
        System.out.println("Extract the name of 5th store");
        System.out.println("The name of 5th store is " + name.get(0));
        System.out.println("**************************************************************");
    }

    @Test
    public void test004() {
        //Extract the names of all the store
        List<String> storesNameList = response.extract().path("data.name");
        System.out.println("Extract the names of all the store");
        System.out.println("The names of all the stores are: ");

        for (String storeName : storesNameList) {
            System.out.println(storeName);
        }
        System.out.println("**************************************************************");
    }
    @Test
    public void test005(){
    List<Integer> storeIDs = response.extract().path("data.id");
        System.out.println("Extract the storeId of all the stores");
        System.out.println("The storeId of all the stores are: ");
        for(int storeId :storeIDs)

    {
        System.out.println(storeId);
    }
        System.out.println("**************************************************************");
}
    @Test
    public void test006(){
        //Print the size of the data list
        List<HashMap<String, ?>> dataList = response.extract().path("data");
        System.out.println("Print the size of the data list");
        System.out.println("The size of the data list is " + dataList.size());
        System.out.println("----**********************************************************");
    }

    @Test
    public void test007(){
        //Get all the value of the store where store name = St Cloud
        List<HashMap<String, ?>> storeNames = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("Get all the value of the store where store name = St Cloud");
        System.out.println("The value of the store where store name = St Cloud is: ");
        for(HashMap<String, ?> store:storeNames){
            System.out.println(store);
        }
        System.out.println("**************************************************************");
    }
    @Test
    public void test008(){
        //get the address of the store where store name=Rochester
        List<String> addressList=response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("Print the address of the store where store name = Rochester");
        System.out.println("The address of the store where store name = 'Rochester' is: " + addressList.get(0));
        System.out.println("**************************************************************");
    }
    @Test
    public void test009(){
        //get all the services of 8th store
//List<HashMap<String,?>>storeServices=response.extract().path("data.findAll{it.id==13}.services.");
        List<HashMap<String, ?>> storeServices = response.extract().path("data[7].services");
        System.out.println("Print all the services of 8th dtore");
        System.out.println("All the services of 8 th store is : "+storeServices);
        System.out.println("**************************************************************");
    }
    @Test
    public void test010(){
        //Get storeservices of the store where service name = Windows Store
        List<HashMap<String, ?>> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Geek Squad Services'}}.services.storeservices");
        System.out.println("Get storeservices of the store where service name = Geek Squad Services");
        System.out.println("The storeservices of the store where service name = Geek Squad Services are: " + storeServices);
        System.out.println("**************************************************************");
    }
    @Test
    public void test011(){
        //Get all the storeId of all the store
        List<Integer> storeIds = response.extract().path("data.services.storeservices.storeId");
        System.out.println("Get all the storeId of all the stores");
        System.out.println("The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");
    }

    @Test
    public void test012(){
        //Get id of all the store
        List<Integer> storeIds = response.extract().path("data.id");
        System.out.println("Get all the storeId of all the stores");
        System.out.println(" The storeId of all the stores are: " + storeIds);
        System.out.println("**************************************************************");
    }

    @Test
    public void test013(){
        //Find the store names Where state = ND
        List<String> storeNames = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("Find the store names Where state = ND");
        System.out.println("The store names Where state = ND is: " + storeNames.get(0));
        System.out.println("**************************************************************");
      //  ??? get(0)

    }


    @Test
    public void test014() {
        //14. Find the Total number of services for the store where store name = Rochester
        List<List<String>> services = response.extract().path("data.findAll{it.name=='Rochester'}.services.name");
        System.out.println("Find the Total number of services for the store where store name = Rochester");
        System.out.println("The total number of services for the store where store name = Rochester are : " + services.get(0).size());
        System.out.println("**************************************************************");
    }
    @Test
    public void test015() {
    //15. Find the createdAt for all services whose name = “Windows Store”
    List<List<String>> createdAt = response.extract().path("data.findAll{it.services.findAll{it.name=='Windows Store'}}.services.createdAt");
        System.out.println("Find the createdAt for all services whose name = Windows Store");
        System.out.println("The createdAt for all services whose name = Windows Store : " + createdAt);
        System.out.println("**************************************************************");
}
    @Test
    public void test016() {
        //16. Find the name of all services Where store name = “Inver Grove Heights”
        List<String> servicesName = response.extract().path("data.findAll{it.name=='Inver Grove Heights'}.services.name");
        System.out.println("Find the createdAt for all services whose name = Windows Store");
        System.out.println("The name of all services Where store name = “Inver Grove Heights” are : " + servicesName);
        System.out.println("**************************************************************");
    }

    @Test
    public void test017() {
        //17. Find the zip of all the store
        List<String> zip = response.extract().path("data.zip");
        System.out.println("Find the zip of all the store");
        System.out.println("The zip of all the stores are : " + zip);
        System.out.println("**************************************************************");
    }
    @Test
    public void test018() {
        //18. Find the zip of store name = Fargo
        List<String> zip = response.extract().path("data.findAll{it.name=='Fargo'}.zip");
        System.out.println("Find the zip of store name = Fargo");
        System.out.println("The zip of store name = Fargo : " + zip.get(0));
        System.out.println("**************************************************************");
    }
    @Test
    public void test019() {
        //19. Find the storeservices details of the service name = Samsung Experience
        List<String> storeServices = response.extract().path("data.findAll{it.services.findAll{it.name=='Samsung Experience'}}.services.storeservices");
        System.out.println("Find the storeservices details of the service name = Samsung Experience");
        System.out.println("The storeservices details of the service name = Samsung Experience : " + storeServices);
        System.out.println("**************************************************************");
    }

    @Test
    public void test020() {
        //20. Find the lat of all the stores
        List<HashMap<String,?>> lat = response.extract().path("data.lat");
        System.out.println("Find the lat of all the stores");
        System.out.println("The latitude of all the stores " + lat);
        System.out.println("**************************************************************");
    }

}

