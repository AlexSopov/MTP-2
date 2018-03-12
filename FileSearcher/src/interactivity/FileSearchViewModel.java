package interactivity;

import javafx.collections.ObservableList;
import searchers.FileSearcher;
import searchers.FileSearcherAsyncDecorator;
import searchers.FileSearcherDefault;
import searchers.callback.FileSearchEventArgs;
import searchers.infrastructure.FileSearchObserver;
import validators.FileValidationRequest;
import validators.RequestValidator;

import java.io.File;

class FileSearchViewModel implements FileSearchObserver {

    private FileSearcher fileSearcher;
    private ObservableList<String> foundItems;

    FileSearchViewModel() {
        FileSearcher defaultFileSearcher = new FileSearcherDefault();
            defaultFileSearcher.addFileSearchObserver(this);

        fileSearcher = new FileSearcherAsyncDecorator(defaultFileSearcher);
    }

    void ExecuteSearch(String searchForValue, String searchFromRootValue, ObservableList<String> foundItems) {
        this.foundItems = foundItems;
        fileSearcher.executeSearch(new FileValidationRequest(searchForValue, searchFromRootValue));
    }

    @Override
    public void onFileSearchEvent(FileSearchEventArgs fileSearchEventArgs) {
        switch (fileSearchEventArgs.getFileSearchEventType()) {

            case FILE_FOUND:
                this.OnFileSearchItemFound(fileSearchEventArgs.getValue());
                break;
            case FILE_RETRIEVED:
                this.OnFileSearchItemRetrieved(fileSearchEventArgs.getValue());
                break;
            case FILE_RETRIEVE_ERROR:
                this.OnFileSearchError(fileSearchEventArgs.getValue());
                break;
        }
    }

    private void OnFileSearchItemFound(String value) {
        foundItems.add(value);
        System.out.println(String.format("Item found: %s", value));
    }

    private void OnFileSearchItemRetrieved(String value) {
        System.out.println(String.format("Item retrieved: %s", value));
    }

    private void OnFileSearchError(String value) {
        System.out.println(String.format("Error: %s", value));
    }
}
