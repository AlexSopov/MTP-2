package validators;

import java.io.File;

public abstract class RequestValidator {
    private RequestValidator Successor;

    abstract boolean isFileSatisfiesRequest(File file, FileValidationRequest fileValidationRequest);

    protected RequestValidator getSuccessor() {
        return Successor;
    }

    protected void setSuccessor(RequestValidator successor) {
        Successor = successor;
    }
}
