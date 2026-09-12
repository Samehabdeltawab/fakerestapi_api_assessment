package com.sameh.qa.api;
import com.sameh.qa.config.ConfigReader; import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder; import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public abstract class BaseApi {
 protected BaseApi(){RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();}
 protected RequestSpecification requestSpec(){return new RequestSpecBuilder()
   .setBaseUri(ConfigReader.get("base.url")).setContentType(ContentType.JSON)
   .setAccept(ContentType.JSON).build();}
}
