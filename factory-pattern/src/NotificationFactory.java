/**
 * This class implements the Factory Method pattern. It provides a static
 * method, {@code createNotification()}, that acts as a factory for creating
 * objects of classes implementing the {@link Notification} interface.
 *
 * The factory method centralizes the creation of notification objects,
 * abstracting the instantiation logic from the client. This makes the system
 * more flexible and easier to extend with new notification types without
 * changing the client code.
 *
 * The client code can create a new notification object by calling the
 * {@code createNotification()} method and passing the desired type of
 * notification (e.g., "SMS", "EMAIL", "PUSH") as an argument. The factory
 * method will return an appropriate concrete implementation of the
 * {@link Notification} interface, or {@code null} if the type is unknown.
 */
class NotificationFactory {

    private NotificationFactory() { }

    /**
     * Creates a {@link Notification} object based on the specified channel.
     * @param channel The type of notification to create (e.g., "SMS", "EMAIL", "PUSH").
     * @return A {@link Notification} object of the specified type, or {@code null}
     */
    public static Notification getInstance(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }

        return switch (channel.toUpperCase()) {
            case "SMS" -> new SMSNotification();
            case "EMAIL" -> new EmailNotification();
            case "PUSH" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown notification channel: " + channel);
        };
    }
}