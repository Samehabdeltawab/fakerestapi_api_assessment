package com.sameh.qa.model;
public class Book {
 private int id,pageCount; private String title,description,excerpt,publishDate;
 public Book() {}
 public int getId(){return id;} public int getPageCount(){return pageCount;}
 public String getTitle(){return title;} public String getDescription(){return description;}
 public String getExcerpt(){return excerpt;} public String getPublishDate(){return publishDate;}
 public void setId(int v){id=v;} public void setPageCount(int v){pageCount=v;}
 public void setTitle(String v){title=v;} public void setDescription(String v){description=v;}
 public void setExcerpt(String v){excerpt=v;} public void setPublishDate(String v){publishDate=v;}
}
