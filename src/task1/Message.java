package task1;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 4/30/15.
 */
public class Message {
  public final Person person;
  public final String title;
  public final String body;

  public Message(Person name, String title, String body) {

    this.person = name;
    this.title = title;
    this.body = body;
  }
}
