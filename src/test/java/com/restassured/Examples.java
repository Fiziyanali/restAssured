package com.restassured;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Examples {

    @Test
    public void test_get(){
        baseURI = "http://localhost:3000/";
        //ismi Automation olan subjectsleri getirir.
        given().param("name","Automation")
                .get("/subjects")
        .then().statusCode(200)
                .log().all();
    }

    @Test
    public void test_post(){
        //POST sadece belirli bir kaynağa veri göndermek için kullanılır ve veri ile ne iş yapılacağı server'a bağlıdır.
        JSONObject request = new JSONObject();
        request.put("firstName", "Fatma");
        request.put("lastName", "DEMİR");
        request.put("subjectId", 1);
        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().post("/users")
                .then().statusCode(201).log().all();
    }

    @Test
    public void test_patch(){
        //patch güncelleme işlemi için kullanılır
        JSONObject request = new JSONObject();
        request.put("lastName", "DEMİRR");
        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().patch("/users/4") //id'si 4 olanı güncelle
                .then().statusCode(200).log().all();
    }

    @Test
    public void test_put(){
        //PUT aynı kaynağa aynı adres ile erişilir ve eğer içerik var ise gelen veriler ile değiştirilir , eğer içerik yok ise yeni içerik yaratılır.
        JSONObject request = new JSONObject();
        request.put("firstName", "Oğuz");
        request.put("lastName", "KAĞAN");
        request.put("subjectId", 1);
        baseURI = "http://localhost:3000/";

        given()
                .header("Content-Type", "application/json")
        .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
        .when().put("/users/4")
                .then().statusCode(200).log().all();
    }

    @Test
    public void test_delete(){
        baseURI = "http://localhost:3000/";
        when().delete("/users/6") //id:5 olani siler
                .then().statusCode(200);
    }
}
