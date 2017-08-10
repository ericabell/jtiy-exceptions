public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Running!");

        // create a new TextContainer
        TextContainer container1 = new TextContainer("first");
        container1.append("appending this string");

        System.out.println("container1 has text: " + container1.getText());

        // create a new TextAppender to hold some TextContainers...
        TextAppenderImpl appender1 = new TextAppenderImpl();

        try {
            appender1.append("key", "string to append");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (CannotAppendException e) {
            System.out.println("catch: " + e);
        }

        try {
            appender1.open("key");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (AlreadyExistsException e) {
            System.out.println("catch: " + e);
        }

        System.out.println("Program executed!");
    }
}
