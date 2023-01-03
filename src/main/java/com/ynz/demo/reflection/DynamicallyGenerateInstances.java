package com.ynz.demo.reflection;

import com.ynz.demo.reflection.appender.Appender;
import com.ynz.demo.reflection.appender.IAppendable;
import org.apache.commons.lang3.ArrayUtils;
import org.reflections.Reflections;

import java.lang.reflect.Method;
import java.util.Set;

public class DynamicallyGenerateInstances {

  public static void main(String[] args)
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    //        Set<String> allTypes =new
    // ReflectionDemo().getAllTypesInPackage("com.ynz.demo.reflection.helper");
    //        System.out.println(allTypes);

    Class<?> c = Class.forName(Appender.class.getName());
    c.newInstance();

    Method[] methods = c.getDeclaredMethods();
    System.out.println(ArrayUtils.toString(methods));

    System.out.println(ArrayUtils.toString(c.getDeclaredAnnotations()));
    System.out.println(ArrayUtils.toString(c.getInterfaces()));
    System.out.println(ArrayUtils.toString(c.getConstructors()));
    System.out.println(c.getPackage());

    Reflections reflections = new Reflections("com.ynz.demo.reflection.helper");

    Set<Class<? extends IAppendable>> subTypes = reflections.getSubTypesOf(IAppendable.class);
    System.out.println(subTypes);

    Appender appender = Appender.class.newInstance();
    appender.append();

    Appender appender1 = Appender.class.newInstance();
    appender1.append();
  }
}
