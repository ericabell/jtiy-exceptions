public class TextContainer {
    private String key;
    private String text;
    private boolean flushed;

    public TextContainer(String key) {
        this.text = "";
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getText() {
        return text;
    }

    public boolean isFlushed() {
        return flushed;
    }

    public void append(String toAppend) {
        text += toAppend;
        flushed = false;
    }

    public void flush() {
        flushed = true;
    }

    @Override
    public String toString() {
        return "TextContainer{" +
                "key='" + key + '\'' +
                ", text='" + text + '\'' +
                ", flushed=" + flushed +
                '}';
    }
}
