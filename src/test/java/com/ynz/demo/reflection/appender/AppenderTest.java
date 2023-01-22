package com.ynz.demo.reflection.appender;

import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AppenderTest {

  @Test
  public void newInstanceByReflection() throws InstantiationException, IllegalAccessException {
    Appender appender = Appender.class.newInstance();
    appender.append();
  }

  @Test
  public void getAllMethodsOfInstanceByReflection() {
    Method[] methods = Appender.class.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println(method.getName());
    }
  }

  @Test
  public void getInstanceFilesByReflection() {
    Field[] fields = Appender.class.getDeclaredFields();
    Arrays.asList(fields).forEach(field -> System.out.println(field.getName()));
  }

  @Test
  public void howToModifyPrivateFieldByReflection()
      throws NoSuchFieldException, IllegalAccessException {
    Appender appender = new Appender();
    Field field = Appender.class.getDeclaredField("initial");
    field.setAccessible(true);
    field.set(appender, "i hacked your content");
    appender.printInitial();
  }
}
