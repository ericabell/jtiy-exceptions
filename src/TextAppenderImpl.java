import java.util.Arrays;

public class TextAppenderImpl implements TextAppender {

    private TextContainer [] containers = new TextContainer[10];
    private int firstOpenIndex = 0;


    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {

        // check and make sure that key isn't already in use
        boolean foundKey = false;
        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null && containers[i].getKey().equals(key)) foundKey = true;
        }
        if (foundKey == false) {
            // since key doesn't exist, we create a new TextContainer
            TextContainer container1 = new TextContainer(key);
            container1.append(text);

            // then put it in containers, if there is space
            if(firstOpenIndex < 9) {
                containers[firstOpenIndex++] = container1;
                throw new DoesNotExistException("key not found, appending...");
            } else {
                // appender is full
                throw new DoesNotExistException("appender is full, cannot append...");
            }

        } else {
            throw new CannotAppendException("key already exists");
        }
    }


    @Override
    public void open(String key) throws AlreadyExistsException {
        // Very DRY
        if (findContainer(key) != null) {
            throw new AlreadyExistsException("key " + key + " already exists");
        }
    }

    @Override
    public void flush(String key) throws DoesNotExistException {
        // if key doesn't exist, throw DoesNotExistException

    }

    @Override
    public void close(String key) throws DoesNotExistException, NeedsFlushException {
        // if key doesn't exist throw DoesNotExistException

        // throws NeedsFlushException if the TextContainer's flushed == false
        // find the TextContainer with the given key
        boolean foundKey = false;
        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null && containers[i].getKey().equals(key)) {
                foundKey = true;
                if (containers[i].isFlushed() == false) {
                    throw new NeedsFlushException("Key: " + key + " needs flushing!");
                }
            }
        }
        if( foundKey == false ) {
            // we never found the key
            throw new DoesNotExistException("Key: " + key + " does not exist.");
        }
    }

    @Override
    public String toString() {
        return "TextAppenderImpl{" +
                "containers=" + Arrays.toString(containers) +
                '}';
    }

    private TextContainer findContainer(String key) {
        for (TextContainer container : containers) {
            if (container != null && container.getKey().equals(key)) {
                return container;
            }
        }

    }
}
