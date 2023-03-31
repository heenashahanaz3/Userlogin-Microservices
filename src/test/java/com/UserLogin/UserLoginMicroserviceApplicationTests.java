package com.UserLogin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;




import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;


@SuppressWarnings("unused")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserLoginMicroserviceApplicationTests {
    
    @Test
    @Order(1)
    public void testLogin() {
        String jsonbody= "{\"email\" : \"anitha@gmail.com\",\"password\" : \"anitha\"}";
        String token=given()
                .header("Content-type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(jsonbody)
                .when()
                .post("http://localhost:8082/authenticate")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();
    }
    
}
