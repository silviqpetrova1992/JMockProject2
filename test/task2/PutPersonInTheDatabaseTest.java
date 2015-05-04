package task2;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class PutPersonInTheDatabaseTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  PersonRepository database;
  @Mock
  Validator validator;

  @Test
  public void happyPath() {
    final Person person1 = new Person("Pesho", "15");

    context.checking(new Expectations() {
      {
        oneOf(validator).validate(person1.age);
        will(returnValue(true));
        exactly(1).of(database).put(person1);
      }
    });
    DataStore dataStore = new DataStore(database, validator);
    dataStore.put(person1);
  }

  @Test
  public void illegalAges() {
    final Person person1 = new Person("Pesho", "9");

    context.checking(new Expectations() {
      {
        oneOf(validator).validate(person1.age);
        will(returnValue(false));
        never(database).put(person1);
      }
    });
    DataStore dataStore = new DataStore(database, validator);
    dataStore.put(person1);
  }


}
