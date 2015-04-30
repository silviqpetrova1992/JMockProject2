package task2;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class PullFromTheDatabaseTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  CustomDatabase database;
  @Mock
  Validator validator;

  @Test
  public void happyPath() {
    final Person person1 = new Person("Pesho", "20");

    context.checking(new Expectations() {
      {
        exactly(1).of(database).pull(person1.name);
        will(returnValue(person1.age));
        oneOf(validator).validate(person1.age);
        will(returnValue(true));

      }
    });
    DatabaseStoring databaseStoring = new DatabaseStoring(database, validator);
    databaseStoring.pull(person1.name);
  }

  @Test(expected =IllegalArgumentException.class)
  public void thePersonDoesntExistInTheDatabase() {
    final Person person1 = new Person("Pesho", "20");

    context.checking(new Expectations() {
      {
        exactly(1).of(database).pull(person1.name);
        will(returnValue(""));
        never(validator).validate(person1.age);
      }
    });
    DatabaseStoring databaseStoring = new DatabaseStoring(database, validator);
    databaseStoring.pull(person1.name);
  }
  @Test(expected = IllegalArgumentException.class)
  public void thePersonIsBelow18() {
    final Person person1 = new Person("Pesho", "10");

    context.checking(new Expectations() {
      {
        exactly(1).of(database).pull(person1.name);
        will(returnValue(person1.age));
        oneOf(validator).validate(person1.age);
        will(returnValue(false));

      }
    });
    DatabaseStoring databaseStoring = new DatabaseStoring(database, validator);
    databaseStoring.pull(person1.name);
  }
}
