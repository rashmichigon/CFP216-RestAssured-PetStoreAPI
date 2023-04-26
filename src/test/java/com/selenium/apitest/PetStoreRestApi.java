package com.selenium.apitest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetStoreRestApi {

    //Pet
    @Test
    public void uploadImageForPetStoreSuccess_ReturnsOK()
    {
        File file = new File("C:\\Users\\Admin\\Pictures\\Screenshots\\Screenshot (1).png");
        Response response = given().accept("application/json")
                .multiPart(file)
                .when()
                .post("https://petstore.swagger.io/v2/pet/101/uploadImage");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void PostAddNewPettoStoreSuccess_ReturnsOK()
    {
        Response response = (Response) given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void PutUpdateanExistingPetSuccess_ReturnsOK()
    {

        Response response = (Response) given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"string\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetFindPetsByStatusSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .pathParam("status","available")
                .when()
                .get( "https://petstore.swagger.io/v2/pet/findByStatus?status=available/{status}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetFindByIDSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .queryParam("petId","9223372016900013000")
                .when()
                .get("https://petstore.swagger.io/v2/pet/9223372016900013000?petId");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void PostUpdatesPetinStoreSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .pathParam("petId","9223372016900013000")
               // .pathParam("name","doggie")
                //.pathParam("status","available")
                .when()
                .post("https://petstore.swagger.io/v2/pet/9223372016900013000/{petId}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
     //Store
    @Test
    public void PostPlaceanOrderforPetSuccess_ReturnsOK()
    {
        Response response = (Response) given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": 0,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2023-04-26T10:01:43.272Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetFindPurchaseOrderByIDSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .queryParam("orderId","1")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1?orderId");
        response.prettyPrint();
        response.then().assertThat().statusCode(404);
    }

    @Test
    public void DeletePurchaseOrderByIDSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .queryParam("orderId","1")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1?orderId");
        response.prettyPrint();
        response.then().assertThat().statusCode(404);
    }

    @Test
    public void GetReturnsPetInventoriesByStatusSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
    
    //User
    @Test
    public void PostCreateListArraySuccess_ReturnsOK()
    {
        Response response = (Response) given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"rashmi\",\n" +
                        "    \"firstName\": \"Rashmi.B\",\n" +
                        "    \"lastName\": \"Chigoni\",\n" +
                        "    \"email\": \"rashmichigon@gmail.com\",\n" +
                        "    \"password\": \"Rashmi$123\",\n" +
                        "    \"phone\": \"7899435223\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]\n" +
                        "[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"rohit\",\n" +
                        "    \"firstName\": \"Rohit.B\",\n" +
                        "    \"lastName\": \"Chigoni\",\n" +
                        "    \"email\": \"rohit@gmail.com\",\n" +
                        "    \"password\": \"Rohit$123\",\n" +
                        "    \"phone\": \"9980629862\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
        .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void PostCreateWithListSuccess_ReturnsOK()
    {
        Response response = (Response) given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 0,\n" +
                        "    \"username\": \"rashmi\",\n" +
                        "    \"firstName\": \"rashmi.b\",\n" +
                        "    \"lastName\": \"chigoni\",\n" +
                        "    \"email\": \"rashmichigon65@gmail.com\",\n" +
                        "    \"password\": \"Rashmi@123\",\n" +
                        "    \"phone\": \"7899435223\",\n" +
                        "    \"userStatus\": 0\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetUserByusernameSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .pathParam("username","rashmi")
                .when()
                .get("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void updateExistingUserInfoSuccess_ReturnOK()
    {
        Response response = given().accept("application/json")
                .contentType("application/json")
                .pathParam("username","rashmi")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"string\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string@gmail.com\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/{username}");

        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void deleteUserFromPetStoreSuccess_ReturnsOK()
    {
        Response response = given().accept("application/json")
                .contentType("application/json")
                .pathParam("username","string")
                .when()
                .delete("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetloggedInToPetStoreSuccess_ReturnsOK()
    {
        Response response = given().header("accept","application/json")
                .queryParam("user","rashmi")
                .queryParam("pass","rashmib")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=rashmi&password=rashmib");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void GetloggedOutFromPetStoreSuccess_ReturnsOK()
    {
        Response response = given().accept("application/json")
                .contentType("application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void CreateUserSuccess_ReturnsOK()
    {
        Response response = given().header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \"rashmi\",\n" +
                        "  \"firstName\": \"Rashmi.B\",\n" +
                        "  \"lastName\": \"Chigon\",\n" +
                        "  \"email\": \"rashmichigon@gmail.com\",\n" +
                        "  \"password\": \"Rashmi$123\",\n" +
                        "  \"phone\": \"7899435223\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);

    }
}
