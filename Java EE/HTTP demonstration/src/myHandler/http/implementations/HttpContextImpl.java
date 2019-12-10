package myHandler.http.implementations;

import myHandler.http.interfaces.HttpContext;
import myHandler.http.interfaces.HttpRequest;
import myHandler.http.interfaces.HttpResponse;

public class HttpContextImpl implements HttpContext {
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public HttpContextImpl(HttpRequest httpRequest, HttpResponse httpResponse) {
        this.setHttpRequest(httpRequest);
        this.setHttpResponse(httpResponse);
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    @Override
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }

    @Override
    public HttpResponse getHttpResponse() {
        return this.httpResponse;
    }
}
