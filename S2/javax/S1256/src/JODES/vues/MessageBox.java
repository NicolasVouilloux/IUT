//correct package - Emma
package JODES.vues;
import javax.swing.*;

/**
 * @author Kincy Saad
 */
public class MessageBox {
  protected String message;
  protected String title;
  protected int optionType;
  protected int response;

  public MessageBox(String message, String title, int optionType) {
    this.message = message;
    this.title = title;
    this.optionType = optionType;
  }

  protected void show() {
    response = JOptionPane.showConfirmDialog(
        null, message, title, optionType);
    handleResponse();
  }

  protected void handleResponse() {
    switch (response) {
      case JOptionPane.YES_OPTION:
        System.out.println("Yes option selected.");
        break;
      case JOptionPane.NO_OPTION:
        System.out.println("No option selected.");
        break;
      case JOptionPane.CANCEL_OPTION:
        System.out.println("Cancel option selected.");
        break;
      case JOptionPane.CLOSED_OPTION:
        System.out.println("Dialog closed without selection.");
        break;
    }
  }

  protected int getResponse() {
    return response;
  }

  public static void main(String[] args) {
    MessageBox messageBox = new MessageBox("Are you sure you want to delete?", "Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
    messageBox.show();
  }
}
