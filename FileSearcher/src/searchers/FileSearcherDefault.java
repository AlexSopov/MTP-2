package searchers;

import searchers.strategies.FileSearchStrategy;
import searchers.strategies.WindowsFileSearcher;
import validators.RequestValidator;

public class FileSearcherDefault extends FileSearcher {
    private FileSearchStrategy fileSearchStrategy;

    public FileSearcherDefault() {
        this.initializeFileSearcherStrategy();
    }

    public void executeSearch(RequestValidator requestValidator) {
        fileSearchStrategy.setFileSearchCallback(this::onFileSearchEvent);
        fileSearchStrategy.ExecuteFileSearch(requestValidator);
    }

    private void initializeFileSearcherStrategy() {
        String operatingSystemName = System.getProperty("os.name").toLowerCase();

        if (operatingSystemName.contains("win")) {
            this.fileSearchStrategy = new WindowsFileSearcher();
        } else if (operatingSystemName.contains("mac")) {
            this.fileSearchStrategy = new WindowsFileSearcher();
        } else if (operatingSystemName.contains("nix") || operatingSystemName.contains("nux") || operatingSystemName.indexOf("aix") > 0) {
            this.fileSearchStrategy = new WindowsFileSearcher();
        } else {
            throw new UnsupportedOperationException(
                    String.format("File searcher is not implemented for operating system type: %s", operatingSystemName));
        }
    }
}
