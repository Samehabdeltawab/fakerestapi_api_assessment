package com.sameh.qa.base;
import com.sameh.qa.api.BooksService; import org.testng.annotations.BeforeClass;
public abstract class BaseApiTest { protected BooksService booksService;
 @BeforeClass public void setUpApi(){booksService=new BooksService();}
}
