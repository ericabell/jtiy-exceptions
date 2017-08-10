

public interface TextAppender {
    void open(String key) throws AlreadyExistsException, DoesNotExistException;
    void append(String key, String text) throws DoesNotExistException, CannotAppendException;
//    void appendEmoji(String key, int emojiIndex) throws DoesNotExistException, CannotAppendException;
    void flush(String key) throws DoesNotExistException;
    void close(String key) throws DoesNotExistException, NeedsFlushException;
}