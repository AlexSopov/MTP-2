package searchers.strategies;

import validators.RequestValidator;

public class LinuxFileSearcher extends FileSearcher {
    @Override
    public void ExecuteFileSearch(RequestValidator requestValidator) {
        throw new UnsupportedOperationException("Currently unsupported.");
    }
}
