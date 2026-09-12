package com.sameh.qa.config;
import java.io.*; import java.util.*;
public final class ConfigReader {
 private static final Properties P=new Properties();
 static { try(InputStream in=ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
   if(in==null) throw new IllegalStateException("config.properties not found"); P.load(in);
 } catch(IOException e){throw new RuntimeException(e);} }
 private ConfigReader(){}
 public static String get(String key){String v=P.getProperty(key); if(v==null||v.isBlank()) throw new IllegalArgumentException("Missing: "+key); return v.trim();}
}
