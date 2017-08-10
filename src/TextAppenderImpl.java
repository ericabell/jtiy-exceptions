import java.util.Arrays;

public class TextAppenderImpl implements TextAppender {

    private TextContainer [] containers = new TextContainer[100];


    @Override
    public void append(String key, String text) throws DoesNotExistException, CannotAppendException {
        // check and make sure that key isn't already in use

        // since key doesn't exist, we create a new TextContainer

        // then put it in containers
    }

    @Override
    public void open(String key) throws AlreadyExistsException {
        // need to check for existence of key in our list of TextContainers

        // if the key exists, we throw AlreadyExistsException
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
