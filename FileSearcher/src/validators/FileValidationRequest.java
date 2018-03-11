package validators;

public class FileValidationRequest {
    private boolean searchInDescription;
    private boolean searchInContent;
    private String requestValue;
    private String startSearchFrom;

    public FileValidationRequest(String requestValue) {
        this.requestValue = requestValue;
        this.startSearchFrom = "";
    }
    public FileValidationRequest(String requestValue, String startSearchFrom) {
        this.requestValue = requestValue;
        this.startSearchFrom = startSearchFrom;
    }

    public boolean getIsSearchInDescription() {
        return searchInDescription;
    }
    public void setSearchInDescription(boolean searchInDescription) {
        this.searchInDescription = searchInDescription;
    }

    public boolean getIsSearchInContent() {
        return searchInContent;
    }
    public void setSearchInContent(boolean searchInContent) {
        this.searchInContent = searchInContent;
    }

    public String getRequestValue() {
        return requestValue;
    }
    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }

    public String getStartSearchFrom() {
        return startSearchFrom;
    }
    public void setStartSearchFrom(String startSearchFrom) {
        this.startSearchFrom = startSearchFrom;
    }
}
