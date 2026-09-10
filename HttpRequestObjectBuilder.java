import java.util.LinkedHashMap;
import java.util.Map;

public class HttpRequestObjectBuilder implements HttpRequestBuilder {
    private String url;
    private String method = "GET";
    private final Map<String, String> headers = new LinkedHashMap<>();
    private String body;

    @Override
    public HttpRequestObjectBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public HttpRequestObjectBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public HttpRequestObjectBuilder addHeader(String key, String value) {
        if (key != null && value != null) {
            this.headers.put(key, value);
        }
        return this;
    }

    @Override
    public HttpRequestObjectBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public HttpRequest getResult() {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("Validation error: URL cannot be null or empty.");
        }
        if (method == null || method.trim().isEmpty()) {
            throw new IllegalStateException("Validation error: HTTP method cannot be null or empty.");
        }
        return new HttpRequest(url, method.toUpperCase(), headers, body);
    }
}