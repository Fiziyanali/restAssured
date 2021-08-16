package com.restassured;

import com.restassured.dal.DataForTests;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples extends DataForTests {

    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId){
        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);
        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @Test(dataProvider = "DeleteData")
    public void test_delete(int id){
        baseURI = "http://localhost:3000/";
        when().delete("/users/"+ id) //id:5 olani siler
                .then().statusCode(200);
    }

    @Parameters({"id"})
    @Test
    public void test_delete2(int id){
        //xml dosyasında bulunan id'yi siler
        System.out.println("ID: " + id);
        baseURI = "http://localhost:3000/";
        when().delete("/users/"+ id) //id:5 olani siler
                .then().statusCode(200);
    }
}
