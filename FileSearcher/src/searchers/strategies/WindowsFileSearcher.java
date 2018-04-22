package searchers.strategies;

import searchers.callback.FileSearchEventType;
import sun.misc.Queue;
import validators.RequestValidator;

import java.io.File;

public class WindowsFileSearcher extends FileSearcher {

    @Override
    public void ExecuteFileSearch(RequestValidator requestValidator) {
        String startSearchSpecificPath = this.getSearchFromSpecificPath(requestValidator);

        if (startSearchSpecificPath.isEmpty()) {
            File[] fileSystemRoots = File.listRoots();

            for (File root : fileSystemRoots) {
                retrieveFilesAndSubdirectories(root, requestValidator);
            }
        } else {
            retrieveFilesAndSubdirectories(new File(startSearchSpecificPath), requestValidator);
        }
    }

    private void retrieveFilesAndSubdirectories(File root, RequestValidator requestValidator) {
        Queue<File> pendingToSearch = new Queue<>();
        pendingToSearch.enqueue(root);

        File currentRoot;
        File[] currentRootSubItems;
        while (!pendingToSearch.isEmpty()) {
            try {
                currentRoot = pendingToSearch.dequeue();
            } catch (InterruptedException e) {
                this.raiseFileSearcherCallback(FileSearchEventType.FILE_RETRIEVE_ERROR, e.getMessage());
                continue;
            }

            currentRootSubItems = currentRoot.listFiles();
            if (currentRootSubItems == null) {
                continue;
            }

            for (File file : currentRootSubItems) {

                this.raiseFileSearcherCallback(FileSearchEventType.FILE_RETRIEVED, file.getAbsolutePath());

                if (requestValidator.isFileSatisfiesRequest(file)) {
                    this.raiseFileSearcherCallback(FileSearchEventType.FILE_FOUND, file.getAbsolutePath());
                }

                if (file.isDirectory()){
                    pendingToSearch.enqueue(file);
                }
            }
        }
    }

    private String getSearchFromSpecificPath(RequestValidator requestValidator) {
        return requestValidator.getFileValidationRequest().getStartSearchFrom();
    }
}
