public class HttpRequestDirector {

    public void makeGetUserProfileRequest(HttpRequestBuilder builder) {
        builder.setUrl("https://api.example.com/v1/users/42")
               .setMethod("GET")
               .addHeader("Accept", "application/json")
               .addHeader("User-Agent", "AppClient/1.0");
    }

    public void makeCreateUserPostRequest(HttpRequestBuilder builder) {
        builder.setUrl("https://api.example.com/v1/users")
               .setMethod("POST")
               .addHeader("Content-Type", "application/json")
               .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1Ni...")
               .setBody("{\"username\": \"john_doe\", \"role\": \"developer\"}");
    }
}