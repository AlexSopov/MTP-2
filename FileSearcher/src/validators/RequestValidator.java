package validators;

import java.io.File;

public abstract class RequestValidator {
    private RequestValidator Successor;
    private FileValidationRequest fileValidationRequest;

    public RequestValidator(FileValidationRequest fileValidationRequest) {
        this.fileValidationRequest = fileValidationRequest;
    }

    public abstract boolean isFileSatisfiesRequest(File file);

    protected RequestValidator getSuccessor() {
        return Successor;
    }

    protected void setSuccessor(RequestValidator successor) {
        Successor = successor;
    }
}
