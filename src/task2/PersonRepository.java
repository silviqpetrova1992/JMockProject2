package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public interface PersonRepository {
  boolean put(Person person);

  String pull(String name);
}
