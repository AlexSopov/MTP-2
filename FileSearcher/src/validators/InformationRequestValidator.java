package validators;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class InformationRequestValidator extends RequestValidator {
    public InformationRequestValidator(FileValidationRequest fileValidationRequest) {
        super(fileValidationRequest);
    }

    @Override
    public boolean isFileSatisfiesRequest(File file) {
        if (fileValidationRequest.getIsSearchInDescription() && this.validateByDescription(file)) {
            return true;
        } else {
            return this.handleBySuccessor(file);
        }
    }

    private boolean validateByDescription(File file) {

        // Crutch. Yep.
        // TODO: implement better way for gathering file description
        try {
            String line = null;
            String filePath = String.format("\"%s\"", file.getAbsolutePath());
            Process p = Runtime.getRuntime().exec("fileInfo.bat " + filePath);
            String processDesc = "";
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (line.contains("File description:"))
                    processDesc = line.split(":")[1].trim();
            }
            input.close();

            return processDesc.contains(this.fileValidationRequest.getRequestValue());

        } catch (IOException e) {
            return false;
        }
    }
}
