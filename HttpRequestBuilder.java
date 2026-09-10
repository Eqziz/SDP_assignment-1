public interface HttpRequestBuilder {
    HttpRequestBuilder setUrl(String url);
    HttpRequestBuilder setMethod(String method);
    HttpRequestBuilder addHeader(String key, String value);
    HttpRequestBuilder setBody(String body);
}