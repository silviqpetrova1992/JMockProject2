package task1;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class MessageSender {
  private final GateWay gateWay;
  private final Validator validator;

  public MessageSender(GateWay gateWay, Validator validator) {

    this.gateWay = gateWay;
    this.validator = validator;
  }

  public void send(Message message) {
if(!validator.validate(message)){
  return;
}
    gateWay.send(message);
  }
}
