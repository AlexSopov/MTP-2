package searchers.decorators;

import searchers.FileSearcherBase;

public abstract class FileSearcherDecorator extends FileSearcherBase {
    protected FileSearcherBase fileSearcherBase;

    public FileSearcherDecorator(FileSearcherBase fileSearcherBase) {
        this.fileSearcherBase = fileSearcherBase;
    }

    public FileSearcherBase getFileSearcherBase() {
        return fileSearcherBase;
    }

    public void setFileSearcherBase(FileSearcherBase fileSearcherBase) {
        this.fileSearcherBase = fileSearcherBase;
    }
}
