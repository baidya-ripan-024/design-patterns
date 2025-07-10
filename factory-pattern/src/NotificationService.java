/**
 * NotificationService is a client class that demonstrates the use of the
 * NotificationFactory. It shows how the client is decoupled from the concrete
 * notification classes.
 *
 * The class contains a main method that creates a notification object using
 * the factory method and sends a notification.
 */
public class NotificationService {

    public static void main(String[] args) {
        // Use the factory to create a notification object for a specific channel
        Notification emailNotifier = NotificationFactory.getInstance("email");
        if (emailNotifier != null) {
            emailNotifier.send("Your order has been shipped!");
        }

        // Easily switch to another notification type by changing the input string.
        Notification smsNotifier = NotificationFactory.getInstance("SMS");
        if (smsNotifier != null) {
            smsNotifier.send("Your package will arrive tomorrow.");
        }

        Notification pushNotifier = NotificationFactory.getInstance("push");
        if (pushNotifier != null) {
            pushNotifier.send("You have a new message.");
        }

        try {
            Notification unknownNotifier = NotificationFactory.getInstance("unknown");
            unknownNotifier.send("This should not be sent.");
        } catch (Exception e) {
            System.out.println("Error occurred. ");
        }
    }
}