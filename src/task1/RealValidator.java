package task1;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class RealValidator implements Validator {

  @Override
  public boolean validate(Message message) {
    if(message.person==null){
return false;
    }
    if(message.title==null||message.title==""){
      return false;
    }
    if(message.body==null||message.body.length()<1||message.body.length()>120){
      return false;
    }
    return true;
  }
}
