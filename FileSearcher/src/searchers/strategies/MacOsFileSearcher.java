package searchers.strategies;

import validators.RequestValidator;

public class MacOsFileSearcher extends FileSearcher {
    @Override
    public void ExecuteFileSearch(RequestValidator requestValidator) {
        throw new UnsupportedOperationException("Currently unsupported.");
    }
}
