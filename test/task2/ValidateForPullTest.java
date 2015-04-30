package task2;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class ValidateForPullTest {
  private ValidatorForPull validator=new ValidatorForPull();
  @Test
  public void happyPath() {
    assertTrue(validator.validate(new Person("Zuz", "43").age));
  }
  @Test
  public void under18YearsOld() {
    assertFalse(validator.validate(new Person("Zuz", "16").age));
  }
}
