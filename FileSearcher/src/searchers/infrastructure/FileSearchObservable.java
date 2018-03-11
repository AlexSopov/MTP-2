package searchers.infrastructure;

import searchers.callback.FileSearchEventArgs;

public interface FileSearchObservable {
    void addFileSearchObserver(FileSearchObserver fileSearchObserver);

    void removeFileSearchObserver(FileSearchObserver fileSearchObserver);

    void notifyObservers(FileSearchEventArgs fileSearchEventArgs);
}
