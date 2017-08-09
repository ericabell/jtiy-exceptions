public class Emojis {

    private String happy = "•ᴗ•";
    private String zombie = "[¬º-°]¬";

    public String getEmoji(int index) throws MissingResourceException {
        switch (index) {
            case 1:
                return happy;
            case 2:
                return zombie;
            default:
                throw new MissingResourceException("Missing emoji for index " + index, "Emojis", Integer.toString(index));
        }
    }
}