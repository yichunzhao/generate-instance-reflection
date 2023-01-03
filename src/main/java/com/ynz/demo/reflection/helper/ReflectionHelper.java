package com.ynz.demo.reflection.helper;

import org.reflections.Reflections;

import java.util.Set;

public class ReflectionHelper {

  /**
   * look for all subtypes of a target class in a specific package.
   *
   * @param packageName the coordinate of a class.
   * @param type a target class type to look for.
   * @param <T> generic type
   * @return a set of subtype classes of target class.
   */
  public <T> Set<Class<? extends T>> getAllSubTypesOfClassInPackage(
      String packageName, Class<T> type) {
    Reflections reflections = new Reflections(packageName);
    return reflections.getSubTypesOf(type);
  }
}
