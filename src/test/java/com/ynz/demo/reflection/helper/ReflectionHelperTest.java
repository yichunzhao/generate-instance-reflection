package com.ynz.demo.reflection.helper;

import com.ynz.demo.reflection.appender.Appender;
import com.ynz.demo.reflection.appender.AppenderProxy;
import com.ynz.demo.reflection.appender.IAppendable;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;

public class ReflectionHelperTest {
  private ReflectionHelper helper;

  @BeforeClass
  public void setup() {
    helper = new ReflectionHelper();
  }

  @Test
  public void testGetAllTypesInPackage() {
    String packageName = "com.ynz.demo.reflection.appender";

    Set<Class<? extends IAppendable>> types =
        helper.getAllSubTypesOfClassInPackage(packageName, IAppendable.class);

    assertThat(types, Matchers.containsInAnyOrder(Appender.class, AppenderProxy.class));
  }
}
