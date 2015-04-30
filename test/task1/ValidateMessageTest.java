package task1;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;


/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class ValidateMessageTest {
  private Validator validator = new RealValidator();
  private Message message;

  @Test
  public void happyPath() {
    message = new Message(new Person("Boby"), "title1", "Body1");
    assertTrue(validator.validate(message));
  }

  @Test
  public void missingPersonToWhomSending() {
    message = new Message(null, "title1", "Body1");
    assertFalse(validator.validate(message));
  }

  @Test
  public void missingTitle() {
    message = new Message(new Person("Boby"), null, "Body1");
    assertFalse(validator.validate(message));
  }

  @Test
  public void emptyStringTitle() {
    message = new Message(new Person("Boby"), "", "Body1");
    assertFalse(validator.validate(message));
  }

  @Test
  public void missingBody() {
    message = new Message(new Person("Boby"), "title2", null);
    assertFalse(validator.validate(message));

  }

  @Test
  public void emptyStringBody() {
    message = new Message(new Person("Boby"), "title2", "");
    assertFalse(validator.validate(message));

  }

  @Test
  public void tooLongBody() {
    message = new Message(new Person("Boby"), "title2", "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
    assertFalse(validator.validate(message));

  }
}
