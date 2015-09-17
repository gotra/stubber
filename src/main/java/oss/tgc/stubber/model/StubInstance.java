package oss.tgc.stubber.model;

/**
 * Created by rajeevguru on 02/07/15.
 */
public class StubInstance {




    Long id;
    String urlPath;
    boolean isActive;
    boolean isSite;
    String directoryPath;
    String httpMethod;
    String headers;
    String response;

    public StubInstance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public StubInstance(Long id, String urlPath, boolean isActive, boolean isSite, String directoryPath, String httpMethod, String headers, String response) {
        this.id = id;
        this.urlPath = urlPath;
        this.isActive = isActive;
        this.isSite = isSite;
        this.directoryPath = directoryPath;
        this.httpMethod = httpMethod;
        this.headers = headers;
        this.response = response;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isSite() {
        return isSite;
    }

    public void setIsSite(boolean isSite) {
        this.isSite = isSite;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }
}
