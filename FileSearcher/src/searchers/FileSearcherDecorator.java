package searchers;

public abstract class FileSearcherDecorator extends FileSearcher {
    protected FileSearcher fileSearcher;

    public FileSearcherDecorator(FileSearcher fileSearcher) {
        this.fileSearcher = fileSearcher;
    }

    public FileSearcher getFileSearcher() {
        return fileSearcher;
    }

    public void setFileSearcher(FileSearcher fileSearcher) {
        this.fileSearcher = fileSearcher;
    }
}
