package core;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Generics {
  public interface Printable {
    String print();
  }
  public interface WithSize {
    int size();
  }

  class User implements Printable, WithSize {
    private String name;

    public User(String n) {
      this.name = n;
    }

    @Override
    public String print() {
      return "[user: " + name + "]";
    }

    @Override
    public int size() {
      return Optional.ofNullable(name).map(String::length).orElse(0);
    }
  }

  public class Envelope<T extends Printable & WithSize> implements WithSize {
    private List<? extends T> payload;
    // private T[] payload2 = new T[10];

    public Envelope(List<? extends T> c) {
      payload = Optional.ofNullable(c).orElse(new LinkedList<>());
    }

    @Override
    public int size() {
      return Optional
        .ofNullable(payload)
        .stream()
        .flatMap(Collection::stream)
        .map(WithSize::size)
        .reduce(Integer::sum)
        .orElse(0);
    }

    public void printAll() {
      Optional
          .ofNullable(payload)
          .stream()
          .flatMap(Collection::stream)
          .map(Printable::print)
          .forEach(System.out::println);
      /**
       * output:
       * 8
       * [user: Milos]
       * [user: Wii]
       */
    }
  }

  public void test() {
    Envelope<User> e = new Envelope<>(List.of(
        new User("Milos"),
        new User("Wii")
    ));
    System.out.println(e.size());
    e.printAll();
  }

  public static void main(String [] args) {
    new Generics().test();
  }
}
