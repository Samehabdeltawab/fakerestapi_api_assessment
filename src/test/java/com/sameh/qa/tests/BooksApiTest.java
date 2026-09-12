package com.sameh.qa.tests;
import com.sameh.qa.base.BaseApiTest; import com.sameh.qa.data.TestDataReader; import com.sameh.qa.model.Book;
import io.restassured.response.Response; import org.testng.Assert; import org.testng.annotations.Test;
public class BooksApiTest extends BaseApiTest {

 @Test(description="Happy path - retrieve all books")
 public void shouldRetrieveAllBooks(){
  Response r=booksService.getAllBooks(); r.then().statusCode(200);
  Book[] books=r.as(Book[].class); Assert.assertTrue(books.length>0);
  for(Book b:books){Assert.assertTrue(b.getId()>0); Assert.assertNotNull(b.getTitle()); Assert.assertTrue(b.getPageCount()>=0);}
 }

 @Test(description="Happy path - create a book")
 public void shouldCreateBookSuccessfully(){
  Book expected=TestDataReader.getBook("validBook"); Response r=booksService.createBook(expected);
  int status=r.getStatusCode(); Assert.assertTrue(status==200||status==201,"Expected 200/201 but was "+status);
  Book actual=r.as(Book.class); Assert.assertEquals(actual.getId(),expected.getId());
  Assert.assertEquals(actual.getTitle(),expected.getTitle()); Assert.assertEquals(actual.getPageCount(),expected.getPageCount());
 }

 @Test(description="Happy path - update an existing book (PUT)")
 public void shouldUpdateBookSuccessfully(){
  // Create an independent book first so this test does not depend on data from other tests.
  Book created=TestDataReader.getBook("validBook");
  Response createResponse=booksService.createBook(created);
  Assert.assertTrue(createResponse.getStatusCode()==200||createResponse.getStatusCode()==201);

  Book updated=TestDataReader.getBook("updatedBook");
  Response r=booksService.updateBook(created.getId(),updated);
  int status=r.getStatusCode(); Assert.assertTrue(status==200,"Expected 200 but was "+status);
  Book actual=r.as(Book.class); Assert.assertEquals(actual.getId(),updated.getId());
  Assert.assertEquals(actual.getTitle(),updated.getTitle()); Assert.assertEquals(actual.getPageCount(),updated.getPageCount());
 }

 @Test(description="Happy path - delete a book")
 public void shouldDeleteBookSuccessfully(){
  // Create an independent book first so this test does not depend on data from other tests.
  Book book=TestDataReader.getBook("validBook");
  Response createResponse=booksService.createBook(book);
  Assert.assertTrue(createResponse.getStatusCode()==200||createResponse.getStatusCode()==201);

  Response r=booksService.deleteBook(book.getId());
  int status=r.getStatusCode();
  // Note: FakeRESTApi simulates the delete and does not persist state, so a subsequent GET
  // may still return the "deleted" book. We only validate the delete call itself here.
  Assert.assertTrue(status==200||status==204,"Expected 200/204 but was "+status);
 }

 @Test(description="Negative - GET book with a non-existent ID")
 public void shouldHandleNonExistentBookId(){
  // FakeRESTApi is a simulation API and does not perform real ID validation/persistence.
  // Requesting a very large, unlikely-to-exist ID is expected to return either:
  //  - 404 Not Found (ideal, real-world behaviour), or
  //  - 200 with a generated/fake book payload (observed/unexpected behaviour of this sandbox API).
  // Both are accepted here, but a 200 response is flagged as unexpected behaviour to note in the report.
  Response r=booksService.getBookById(999999); int status=r.getStatusCode();
  Assert.assertTrue(status==404||status==200,"Expected 404 or 200 but was "+status);
  if(status==200){
   System.out.println("NOTE: Unexpected behaviour - FakeRESTApi returned 200 for a non-existent book ID instead of 404.");
  }
 }
}

