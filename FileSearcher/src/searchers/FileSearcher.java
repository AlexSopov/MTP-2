package searchers;

import validators.RequestValidator;

public class FileSearcher {
    private RequestValidator requestValidator;

    public FileSearcher (RequestValidator requestValidator) {
        this.requestValidator = requestValidator;
    }

}
