/**
 * This interface defines a contract for all types of notifications. It includes a single abstract method, send(),
 * which must be implemented by any concrete class that represents a specific notification type.
 * This design ensures that client code can interact consistently with various notification objects
 * without relying on their concrete implementations.
 */
interface Notification {
    // Sends a notification with the specified message content.
    void send(String message);
}

/**
 * A concrete implementation of the {@link Notification} interface dedicated to sending email notifications.
 */
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Sending Email: " + message);
        // business logic
    }
}

/**
 * A concrete implementation of the {@link Notification} interface for sending SMS text messages to mobile phones.
 */
class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📱 Sending SMS: " + message);
        // business logic
    }
}

/**
 * A concrete implementation of the {@link Notification} interface for sending push notifications to mobile devices.
 */
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("🔔 Sending Push Notification: " + message);
        // business logic
    }
}