package searchers.strategies;

import searchers.callback.FileSearchCallback;
import searchers.callback.FileSearchEventArgs;
import searchers.callback.FileSearchEventType;
import validators.RequestValidator;

public abstract class FileSearcher {

    private FileSearchCallback fileSearchCallback;

    public abstract void ExecuteFileSearch(RequestValidator requestValidator);

    public void raiseFileSearcherCallback(FileSearchEventType fileSearchEventType, String value) {
        if (fileSearchCallback != null) {
            fileSearchCallback.onFileSearchEvent(new FileSearchEventArgs(fileSearchEventType, value));
        }
    }

    public FileSearchCallback getFileSearchCallback() {
        return fileSearchCallback;
    }

    public void setFileSearchCallback(FileSearchCallback fileSearchCallback) {
        this.fileSearchCallback = fileSearchCallback;
    }
}
