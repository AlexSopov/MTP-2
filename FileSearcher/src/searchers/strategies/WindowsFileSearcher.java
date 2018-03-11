package searchers.strategies;

import searchers.callback.FileSearchEventType;
import sun.misc.Queue;
import validators.RequestValidator;

import java.io.File;

public class WindowsFileSearcher extends FileSearchStrategy {

    @Override
    public void ExecuteFileSearch(RequestValidator requestValidator) {
        File[] fileSystemRoots = File.listRoots();

        for (File root : fileSystemRoots) {
            retrieveFilesAndSubdirectories(root, requestValidator);
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

                this.raiseFileSearcherCallback(FileSearchEventType.FILE_RETRIEVED, root.getAbsolutePath());

                // Execute validation
                if (requestValidator.isFileSatisfiesRequest(file)) {
                    this.raiseFileSearcherCallback(FileSearchEventType.FILE_FOUND, file.getAbsolutePath());
                }

                if (file.isDirectory()){
                    pendingToSearch.enqueue(file);
                }
            }
        }
    }
}
