package core;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Annotations {
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  public @interface Length {
    int minLength();
  }
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  @Inherited // Subclass inherits Superclass 's annotation
  public @interface Validate {

  }

  public static <T> void validate(T object) throws IllegalAccessException {
    Class<?> clazz = object.getClass();
    for (Field f : clazz.getDeclaredFields()) {
      if (f.isAnnotationPresent(Validate.class)) {
        Length length = f.getAnnotation(Length.class);
        if (length != null && f.getType() == String.class) {
          f.setAccessible(true);
          String value = (String) f.get(object);
          if (value == null || value.length() < length.minLength()) {
            throw new RuntimeException("minLength requirement failed");
          }
        }
      }
    }
  }

  public static class User {
    private final String name;
    @Validate
    @Length(minLength = 50)
    private final String username;

    public User(String name, String username) {
      this.name = name;
      this.username = username;
    }

    public String print() {
      return name + username;
    }

  }

  public static void main(String [] args) throws IllegalAccessException {
    User user = new User("Milos", "milenibgd@gmail.com");
    validate(user);
    System.out.println(user.print());
  }
}
