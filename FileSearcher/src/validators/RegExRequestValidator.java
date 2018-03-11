package validators;

import java.io.File;

public class RegExRequestValidator extends RequestValidator {

    public RegExRequestValidator(FileValidationRequest fileValidationRequest) {
        super(fileValidationRequest);
    }

    @Override
    public boolean isFileSatisfiesRequest(File file) {
        if (file.getName().matches(fileValidationRequest.getRequestValue())) {
            return true;
        } else {
            return this.handleBySuccessor(file);
        }
    }
}
