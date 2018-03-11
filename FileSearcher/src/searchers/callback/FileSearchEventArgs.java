package searchers.callback;

public class FileSearchEventArgs {
    private FileSearchEventType fileSearchEventType;
    private String value;

    public FileSearchEventArgs(FileSearchEventType fileSearchEventType, String value) {
        this.fileSearchEventType = fileSearchEventType;
        this.value = value;
    }

    public FileSearchEventType getFileSearchEventType() {
        return fileSearchEventType;
    }

    public void setFileSearchEventType(FileSearchEventType fileSearchEventType) {
        this.fileSearchEventType = fileSearchEventType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
