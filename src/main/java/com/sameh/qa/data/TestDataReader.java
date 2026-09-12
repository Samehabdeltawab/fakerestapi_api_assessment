package com.sameh.qa.data;
import com.fasterxml.jackson.databind.*; import com.sameh.qa.model.Book; import java.io.*;
public final class TestDataReader {
 private static final ObjectMapper M=new ObjectMapper(); private TestDataReader(){}
 public static Book getBook(String name){
  try(InputStream in=TestDataReader.class.getClassLoader().getResourceAsStream("test-data/books.json")){
   if(in==null) throw new IllegalStateException("books.json not found");
   JsonNode root=M.readTree(in); return M.treeToValue(root.get(name),Book.class);
  }catch(IOException e){throw new RuntimeException(e);}
 }
}
