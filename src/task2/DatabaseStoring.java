package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class DatabaseStoring {
  private final CustomDatabase database;
  private final Validator validator;

  public DatabaseStoring(CustomDatabase database, Validator validator) {

    this.database = database;
    this.validator = validator;
  }

  public void put(Person person1) {
if(!validator.validate(person1.age)){
  return;
}
    database.put(person1);
  }

  public String pull(String name) {
    String age=database.pull(name);
if(age==""){
  throw new IllegalArgumentException("The database can't find that name!");
}
 if(!validator.validate(age)){
     throw new IllegalArgumentException("The person is below 18!");
    }
    return age;
  }
}
