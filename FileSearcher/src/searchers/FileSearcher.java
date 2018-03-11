package searchers;

import searchers.callback.FileSearchEventArgs;
import searchers.infrastructure.FileSearchObservable;
import searchers.infrastructure.FileSearchObserver;
import validators.RequestValidator;

import java.util.ArrayList;
import java.util.List;

public abstract class FileSearcher implements FileSearchObservable {
    private List<FileSearchObserver> observers;

    FileSearcher() {
        this.observers = new ArrayList<>();
    }

    public abstract void executeSearch(RequestValidator requestValidator);

    public void addFileSearchObserver(FileSearchObserver fileSearchObserver) {
        this.validateFileSearchObserver(fileSearchObserver);
        this.observers.add(fileSearchObserver);
    }

    public void removeFileSearchObserver(FileSearchObserver fileSearchObserver) {
        this.validateFileSearchObserver(fileSearchObserver);
        this.observers.remove(fileSearchObserver);
    }

    public void notifyObservers(FileSearchEventArgs fileSearchEventArgs) {
        for (FileSearchObserver observer : observers) {
            observer.onFileSearchEvent(fileSearchEventArgs);
        }
    }

    void onFileSearchEvent(FileSearchEventArgs fileSearchEventArgs) {
        notifyObservers(fileSearchEventArgs);
    }

    private void validateFileSearchObserver(FileSearchObserver instance) {
        if (instance == null) {
            throw new IllegalArgumentException("Observer should be not null.");
        }
    }
}
