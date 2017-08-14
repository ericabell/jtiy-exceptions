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
            System.out.println("ERROR should have thrown DoesNotExistException");
        }
        catch (DoesNotExistException e) {
            System.out.println("SUCCESS could not append to first");
        }
        catch (CannotAppendException e) {
            System.out.println("ERROR should not get this ");
        }

        // try to open at key: "first"
        try {
            appender1.open("first");
            System.out.println("SUCCESS was able to open first");
        }
        catch (Exception e) {
            System.out.println("ERROR: should have been able to open first " + e.getMessage());
        }

        try {
            appender1.open("first");
            System.out.println("ERROR: should not have been able to open first again");
        } catch (AlreadyExistsException e) {
            System.out.println("SUCCESS: could not open first again");
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
