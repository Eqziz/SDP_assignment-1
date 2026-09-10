import java.util.LinkedHashMap;
import java.util.Map;

public class CurlStringBuilder implements HttpRequestBuilder {
    private String url;
    private String method = "GET";
    private final Map<String, String> headers = new LinkedHashMap<>();
    private String body;

    @Override
    public CurlStringBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public CurlStringBuilder setMethod(String method) {
        this.method = method;
        return this;
    }

    @Override
    public CurlStringBuilder addHeader(String key, String value) {
        if (key != null && value != null) {
            this.headers.put(key, value);
        }
        return this;
    }

    @Override
    public CurlStringBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    public String getResult() {
        if (url == null || url.trim().isEmpty()) {
            throw new IllegalStateException("Validation error: URL is required to generate a cURL command.");
        }

        StringBuilder curl = new StringBuilder("curl -X ").append(method.toUpperCase());
        curl.append(" \"").append(url).append("\"");

        for (Map.Entry<String, String> header : headers.entrySet()) {
            curl.append(" -H \"").append(header.getKey()).append(": ").append(header.getValue()).append("\"");
        }

        if (body != null && !body.trim().isEmpty()) {
            curl.append(" -d '").append(body).append("'");
        }

        return curl.toString();
    }
}