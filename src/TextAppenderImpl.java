import java.util.Arrays;

public class TextAppenderImpl implements TextAppender {

    private TextContainer [] containers = new TextContainer[100];


    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {

        // check and make sure that key isn't already in use
        boolean foundKey = false;
        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null && containers[i].getKey() == key) foundKey = true;
        }
        if (foundKey == false) {
            // since key doesn't exist, we create a new TextContainer
            TextContainer container1 = new TextContainer(key);
            container1.append(text);

            // then put it in containers TODO: how do I find the correct index?
            containers[0] = container1;
            throw new DoesNotExistException("key not found");
        } else {
            System.out.println("key already exists!");
            throw new CannotAppendException("key already exists");
        }
    }


    @Override
    public void open(String key) throws AlreadyExistsException, DoesNotExistException {
        // need to check for existence of key in our list of TextContainers
        boolean foundKey = false;
        for (int i = 0; i < containers.length; i++) {
            if (containers[i] != null && containers[i].getKey() == key) foundKey = true;
        }
        if (foundKey == false) {
            // no TextContainer with the given key exists
            throw new DoesNotExistException("key not found");
        } else {
            System.out.println("key already exists!");
            throw new AlreadyExistsException("key already exists");
        }
    }

    @Override
    public void flush(String key) throws DoesNotExistException {
        // if key doesn't exist, throw DoesNotExistException

    }

    @Override
    public void close(String key) throws DoesNotExistException, NeedsFlushException {
        // if key doesn't exist throw DoesNotExistException

        // throws
    }

    @Override
    public String toString() {
        return "TextAppenderImpl{" +
                "containers=" + Arrays.toString(containers) +
                '}';
    }
}
