package task2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class PutValidationTest {
  private ValidatorImp validator=new ValidatorImp(10,100);
  @Test
  public void happyPath() {
     assertTrue(validator.validate(new Person("Zuz", "43").age));
  }
  @Test
  public void nullAges() {
    assertFalse(validator.validate(new Person("Zuz", null).age));
  }
  @Test
  public void tooYoung() {
    assertFalse(validator.validate(new Person("Zuz", "9").age));
  }
  @Test
  public void tooOld() {
    assertFalse(validator.validate(new Person("Zuz", "109").age));
  }
}
