package com.sameh.qa.api;
import com.sameh.qa.config.ConfigReader; import com.sameh.qa.model.Book; import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class BooksService extends BaseApi {
 private final String path=ConfigReader.get("books.path");
 public Response getAllBooks(){return given().spec(requestSpec()).when().get(path);}
 public Response getBookById(int id){return given().spec(requestSpec()).pathParam("id",id).when().get(path+"/{id}");}
 public Response createBook(Book book){return given().spec(requestSpec()).body(book).when().post(path);}
 public Response updateBook(int id, Book book){return given().spec(requestSpec()).pathParam("id",id).body(book).when().put(path+"/{id}");}
 public Response deleteBook(int id){return given().spec(requestSpec()).pathParam("id",id).when().delete(path+"/{id}");}
}
