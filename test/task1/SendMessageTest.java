package task1;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class SendMessageTest {
  private Person peter;
  private Person ivan;
  private Message message;
  private MessageSender messageSender;

  @Before
  public void setUp() {
    peter = new Person("Peter");
    ivan = new Person("Ivan");
    messageSender = new MessageSender(gateWay, validator);
  }

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  Validator validator;
  @Mock
  GateWay gateWay;

  @Test
  public void happyPath() {
    message = new Message(ivan, "Hello", "How are you?");
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(true));
        exactly(1).of(gateWay).send(message);
      }
    });
    messageSender.send(message);
  }

  @Test
  public void sendingIncorrectMessage() {
    message = new Message(ivan, "", "How are you?");
    context.checking(new Expectations() {
      {
        oneOf(validator).validate(message);
        will(returnValue(false));
        never(gateWay).send(message);
      }
    });
    messageSender.send(message);
  }
}
