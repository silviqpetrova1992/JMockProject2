package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class ValidatorImp implements Validator {

  private final int from;
  private final int to;

  public ValidatorImp(int from, int to) {

    this.from = from;
    this.to = to;
  }

  @Override
  public boolean validate(String age) {
    int intAge;
    try{
      intAge=Integer.parseInt(age);
    }catch(Exception e){
      return false;
    }
    if (intAge < from||intAge>to) {
      return false;
    }
    return true;
  }
}
