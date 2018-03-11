package validators;

import java.io.File;

public abstract class RequestValidator {
    private RequestValidator successor;

    public FileValidationRequest getFileValidationRequest() {
        return fileValidationRequest;
    }

    public void setFileValidationRequest(FileValidationRequest fileValidationRequest) {
        this.fileValidationRequest = fileValidationRequest;
    }

    public RequestValidator getSuccessor() {
        return successor;
    }

    public void setSuccessor(RequestValidator successor) {
        this.successor = successor;
    }

    protected FileValidationRequest fileValidationRequest;

    public RequestValidator(FileValidationRequest fileValidationRequest) {
        this.fileValidationRequest = fileValidationRequest;
    }

    public abstract boolean isFileSatisfiesRequest(File file);

    protected boolean handleBySuccessor(File file) {
        return successor != null && successor.isFileSatisfiesRequest(file);
    }


}
