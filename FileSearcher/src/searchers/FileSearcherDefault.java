package searchers;

import searchers.strategies.FileSearcher;
import searchers.strategies.MacOsFileSearcher;
import searchers.strategies.WindowsFileSearcher;
import validators.*;

public class FileSearcherDefault extends FileSearcherBase {
    private FileSearcher fileSearchStrategy;
    private RequestValidator requestValidator;

    public void executeSearch(FileValidationRequest fileValidationRequest) {
        this.initializeFileSearcherStrategy(fileValidationRequest);

        fileSearchStrategy.setFileSearchCallback(this::onFileSearchEvent);
        fileSearchStrategy.ExecuteFileSearch(requestValidator);
    }

    private void initializeFileSearcherStrategy(FileValidationRequest fileValidationRequest) {
        String operatingSystemName = System.getProperty("os.name").toLowerCase();

        if (operatingSystemName.contains("win")) {
            this.initializeForWindows(fileValidationRequest);
        } else if (operatingSystemName.contains("mac")) {
            this.initializeForMac(fileValidationRequest);
        } else if (operatingSystemName.contains("nix") || operatingSystemName.contains("nux") || operatingSystemName.indexOf("aix") > 0) {
            this.initializeForUnix(fileValidationRequest);
        } else {
            throw new UnsupportedOperationException(
                    String.format("File searcher is not implemented for operating system: %s", operatingSystemName));
        }
    }

    private void initializeForWindows(FileValidationRequest fileValidationRequest) {
        this.fileSearchStrategy = new WindowsFileSearcher();

        RequestValidator nameRequestValidator = new NameRequestValidator(fileValidationRequest);
        RequestValidator regExRequestValidator = new RegExRequestValidator(fileValidationRequest);
        RequestValidator infoRequestValidator = new InformationRequestValidator(fileValidationRequest);
        RequestValidator contentRequestValidator = new ContentRequestValidator(fileValidationRequest);

        nameRequestValidator.setSuccessor(regExRequestValidator);
        regExRequestValidator.setSuccessor(infoRequestValidator);
        infoRequestValidator.setSuccessor(contentRequestValidator);

        requestValidator = nameRequestValidator;
    }

    private void initializeForMac(FileValidationRequest fileValidationRequest) {
        this.fileSearchStrategy = new MacOsFileSearcher();

        RequestValidator nameRequestValidator = new NameRequestValidator(fileValidationRequest);
        RequestValidator regExRequestValidator = new RegExRequestValidator(fileValidationRequest);
        RequestValidator contentRequestValidator = new ContentRequestValidator(fileValidationRequest);

        nameRequestValidator.setSuccessor(regExRequestValidator);
        regExRequestValidator.setSuccessor(contentRequestValidator);

        requestValidator = nameRequestValidator;
    }

    private void initializeForUnix(FileValidationRequest fileValidationRequest) {
        RequestValidator nameRequestValidator = new NameRequestValidator(fileValidationRequest);
        RequestValidator regExRequestValidator = new RegExRequestValidator(fileValidationRequest);

        nameRequestValidator.setSuccessor(regExRequestValidator);

        requestValidator = nameRequestValidator;
    }
}
