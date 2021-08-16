package com.restassured.trials;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Tests_Requests {

    @Test
    public void test_1_post() { //Basit bit post isteği
       /*
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Beyza");
        map.put("job","CE");
        System.out.println(map);
        */
        //Json formatına çevirme
        JSONObject request = new JSONObject();
        request.put("name", "Beyza");
        request.put("job","CE");
        System.out.println(request);
        System.out.println(request.toJSONString());

        //Code 201:created
        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().post("https://reqres.in/api/users")
                .then().statusCode(201);
    }

    @Test
    public void test_2_put() { //Basit bit put isteği
        //Json formatına çevirme
        JSONObject request = new JSONObject();
        request.put("name", "Beyza");
        request.put("job","CE");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().put("https://reqres.in/api/users/2")
                .then().statusCode(200)
        .log().all();
    }

    @Test
    public void test_3_patch() { //Basit bit patch isteği
        //Json formatına çevirme
        JSONObject request = new JSONObject();
        request.put("name", "Beyza");
        request.put("job","CE");
        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().patch("https://reqres.in/api/users/2")
                .then().statusCode(200)
        .log().all();
    }

    @Test
    public void test_4_delete() { //Basit bit delete işlemi
        //Code 204: no content
        when().delete("https://reqres.in/api/users/2")
                .then().statusCode(204)
        .log().all();
    }
}
