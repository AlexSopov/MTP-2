package validators;

import java.io.File;

public class NameRequestValidator extends RequestValidator {

    public NameRequestValidator(FileValidationRequest fileValidationRequest) {
        super(fileValidationRequest);
    }

    @Override
    public boolean isFileSatisfiesRequest(File file) {

        if (file.getName().contains(fileValidationRequest.getRequestValue())) {
            return true;
        } else {
            return this.handleBySuccessor(file);
        }
    }
}
