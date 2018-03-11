package validators;

import java.io.File;

public class ContentRequestValidator extends RequestValidator {
    public ContentRequestValidator(FileValidationRequest fileValidationRequest) {
        super(fileValidationRequest);
    }

    @Override
    public boolean isFileSatisfiesRequest(File file) {

        // TODO: implement
        return false;
    }
}
