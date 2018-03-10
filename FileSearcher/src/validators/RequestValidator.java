package validators;

import java.io.File;

public interface RequestValidator {
    public boolean isFileValid(File file, FileValidationRequest fileValidationRequest);
}
