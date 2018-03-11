package searchers;

import validators.RequestValidator;

public class FileSearcherAsyncDecorator extends FileSearcherDecorator {

    public FileSearcherAsyncDecorator(FileSearcher fileSearcher) {
        super(fileSearcher);
    }

    @Override
    public void executeSearch(RequestValidator requestValidator) {
        Thread executiveThread = new Thread(new AsyncSearcher(requestValidator));
        executiveThread.start();
    }

    private class AsyncSearcher implements Runnable {

        private RequestValidator requestValidator;

        AsyncSearcher(RequestValidator requestValidator) {
            this.requestValidator = requestValidator;
        }

        @Override
        public void run() {
            fileSearcher.executeSearch(requestValidator);
        }
    }
}
