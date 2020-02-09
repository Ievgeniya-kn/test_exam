package com;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;


public class Register {

    public User userToRegister = new User();

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://167.172.110.35/";
        RestAssured.port = 80;
        RestAssured.basePath = "/register";
    }


    @Test
    public void postNewSpeciality() {

        userToRegister.setUsername("Test User");
        userToRegister.setEmail("test@test.com");
        userToRegister.setPassword("123456");


        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(userToRegister)
                .post();


        assertEquals(500,response.getStatusCode(),"User is created now");

    }

}



