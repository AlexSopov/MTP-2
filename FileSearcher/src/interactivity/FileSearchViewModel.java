package interactivity;

import javafx.collections.ObservableList;
import searchers.FileSearcherBase;
import searchers.decorators.FileSearcherAsyncDecorator;
import searchers.FileSearcherDefault;
import searchers.callback.FileSearchEventArgs;
import searchers.infrastructure.FileSearchObserver;
import validators.FileValidationRequest;

class FileSearchViewModel implements FileSearchObserver {

    private FileSearcherBase fileSearcherBase;
    private ObservableList<String> foundItems;

    FileSearchViewModel() {
        FileSearcherBase defaultFileSearcherBase = new FileSearcherDefault();
        defaultFileSearcherBase.addFileSearchObserver(this);

        fileSearcherBase = new FileSearcherAsyncDecorator(defaultFileSearcherBase);
    }

    void ExecuteSearch(FileValidationRequest fileValidationRequest, ObservableList<String> foundItems) {
        this.foundItems = foundItems;
        fileSearcherBase.executeSearch(fileValidationRequest);
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
        //System.out.println(String.format("Item found: %s", value));
    }

    private void OnFileSearchItemRetrieved(String value) {
        //System.out.println(String.format("Item retrieved: %s", value));
    }

    private void OnFileSearchError(String value) {
        System.out.println(String.format("Error: %s", value));
    }
}
