package searchers.infrastructure;

import searchers.callback.FileSearchEventArgs;

public interface FileSearchObserver {
    void onFileSearchEvent(FileSearchEventArgs fileSearchEventArgs);
}
