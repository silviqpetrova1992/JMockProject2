package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class ValidatorForPull implements Validator {
  @Override
  public boolean validate(String age) {

    if((Integer.parseInt(age))<18){
      return false;
    }
    return true;
  }
}
