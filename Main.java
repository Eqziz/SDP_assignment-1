public class Main {
    public static void main(String[] args) {
        HttpRequestDirector director = new HttpRequestDirector();

        System.out.println("=== 1. Building via Director: POST Request ===");

        HttpRequestObjectBuilder objectBuilder = new HttpRequestObjectBuilder();
        director.makeCreateUserPostRequest(objectBuilder);
        HttpRequest postRequest = objectBuilder.getResult();
        System.out.println("Object representation:\n" + postRequest + "\n");

        CurlStringBuilder curlBuilder = new CurlStringBuilder();
        director.makeCreateUserPostRequest(curlBuilder);
        String curlCommand = curlBuilder.getResult();
        System.out.println("cURL representation:\n" + curlCommand + "\n");

        System.out.println("=== 2. Custom Request via Fluent API ===");
        HttpRequest customRequest = new HttpRequestObjectBuilder()
                .setUrl("https://api.example.com/v1/health")
                .setMethod("GET")
                .addHeader("X-Trace-Id", "98765-abc")
                .getResult();
        System.out.println("Custom built object:\n" + customRequest + "\n");

        System.out.println("=== 3. Validation Failure Test ===");
        try {
            HttpRequestObjectBuilder brokenBuilder = new HttpRequestObjectBuilder();
            brokenBuilder.setMethod("POST").getResult();
        } catch (IllegalStateException e) {
            System.out.println("Successfully caught validation error: " + e.getMessage());
        }
    }
}