package task2;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class PutInTheDatabaseTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  CustomDatabase database;
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
    DatabaseStoring databaseStoring = new DatabaseStoring(database, validator);
    databaseStoring.put(person1);
  }
  @Test
  public void illigalAges() {
    final Person person1 = new Person("Pesho", "9");

    context.checking(new Expectations() {
      {
        oneOf(validator).validate(person1.age);
        will(returnValue(false));
        never(database).put(person1);
      }
    });
    DatabaseStoring databaseStoring = new DatabaseStoring(database, validator);
    databaseStoring.put(person1);
  }
}
