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

        // append at key: "first"
        try {
            appender1.append("first", "string to append");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (CannotAppendException e) {
            System.out.println("catch: " + e);
        }

        // try to open at key: "first"
        try {
            appender1.open("first");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (AlreadyExistsException e) {
            System.out.println("catch: " + e);
        }

        // append at key: "second"
        try {
            appender1.append("second", "string to append");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (CannotAppendException e) {
            System.out.println("catch: " + e);
        }

        // try to append at key: "second"
        try {
            appender1.append("second", "string to append");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (CannotAppendException e) {
            System.out.println("catch: " + e);
        }

        try {
            appender1.close("second");
        }
        catch (DoesNotExistException e) {
            System.out.println("catch: " + e);
        }
        catch (NeedsFlushException e) {
            System.out.println("catch: " + e);
        }


        // toString() will print out all the TextContainers
        System.out.println(appender1.toString());

        System.out.println("Program executed!");
    }
}
