package core;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {
  public enum UserType {
    ADMIN, DRIVER, CLIENT
  }
  public static class User {
    public UserType userType;
    public String name;
    public User(UserType userType, String name) {
      this.userType = userType;
      this.name = name;
    }
  }

  // Just for Demo purpose, A and R are not the same type
  static class UsersCollector implements Collector<User, Map<UserType, List<User>>, Map<UserType, Integer>> {
    @Override
    public Supplier<Map<UserType, List<User>>> supplier() {
      return HashMap::new;
    }

    @Override
    public BiConsumer<Map<UserType, List<User>>, User> accumulator() {
      return (acc, curr) -> {
        if (!acc.containsKey(curr.userType)) {
          acc.put(curr.userType, new LinkedList<>());
        }
        acc.get(curr.userType).add(curr);
      };
    }

    @Override
    public BinaryOperator<Map<UserType, List<User>>> combiner() {
      // Used with parallel streams.
      return (first, second) -> first;
    }

    @Override
    public Function<Map<UserType, List<User>>, Map<UserType, Integer>> finisher() {
      return acc -> acc.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().size()));
    }

    @Override
    public Set<Characteristics> characteristics() {
      return Collections.emptySet();
    }
  }

  public static void main(String [] args) {
    List<User> users = List.of(
        new User(UserType.ADMIN, "Milos Milenovic"),
        new User(UserType.DRIVER, "Petar Mitic"),
        new User(UserType.DRIVER, "Marko Stankovic"),
        new User(UserType.CLIENT, "Avram Gojic"),
        new User(UserType.CLIENT, "Matko Mitic"),
        new User(UserType.CLIENT, "Janjos Babic")
    );
    Map<UserType, Integer> result = users.stream().collect(new UsersCollector());

    // This is how I would do it in production
    Map<UserType, Long> result2 = users.stream()
      .collect(Collectors.groupingBy(val -> val.userType, Collectors.counting()));
  }
}

