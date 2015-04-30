package task2;

import task1.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class ValidatorForPut implements Validator {
  @Override
  public boolean validate(String age) {
    int intAge;
    try{
    intAge=Integer.parseInt(age);
    }catch(Exception e){
      return false;
    }
    if(intAge<=10||intAge>=100){
      return false;
    }
    return true;
  }
}
