package oss.tgc.stubber.model;

/**
 * Created by rajeevguru on 02/07/15.
 */
public class StubInstance {




    Long id;
    String name;
    String description;
    String urlPath;
    String httpMethod;
    String responseHeaders;
    String response;

    public StubInstance() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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


    public StubInstance(Long id, String name, String description, String urlPath, String httpMethod, String responseHeaders, String response) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.urlPath = urlPath;
        this.httpMethod = httpMethod;
        this.responseHeaders = responseHeaders;
        this.response = response;
    }


    public String getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    @Override
    public String toString() {
        return "StubInstance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", urlPath='" + urlPath + '\'' +
                ", httpMethod='" + httpMethod + '\'' +
                ", responseHeaders='" + responseHeaders + '\'' +
                ", response='" + response + '\'' +
                '}';
    }


}
