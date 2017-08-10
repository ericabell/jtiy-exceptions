public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Running!");

        // create a new TextContainer
        TextContainer container1 = new TextContainer("first");
        container1.append("appending this string");

        System.out.println("container1 has text: " + container1.getText());
    }
}
