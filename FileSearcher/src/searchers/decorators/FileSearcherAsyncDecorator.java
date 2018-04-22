package searchers.decorators;

import searchers.FileSearcherBase;
import validators.FileValidationRequest;

public class FileSearcherAsyncDecorator extends FileSearcherDecorator {

    public FileSearcherAsyncDecorator(FileSearcherBase fileSearcherBase) {
        super(fileSearcherBase);
    }

    @Override
    public void executeSearch(FileValidationRequest fileValidationRequest) {
        Thread executiveThread = new Thread(new AsyncSearcher(fileValidationRequest));
        executiveThread.start();
    }

    private class AsyncSearcher implements Runnable {

        private FileValidationRequest fileValidationRequest;

        AsyncSearcher(FileValidationRequest fileValidationRequest) {
            this.fileValidationRequest = fileValidationRequest;
        }

        @Override
        public void run() {
            fileSearcherBase.executeSearch(fileValidationRequest);
        }
    }
}
