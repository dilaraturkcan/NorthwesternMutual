package utils;

import io.cucumber.java.nl.Stel;

public class PayLoads {
    public static String getUserPayload(String zipcode, String name, String userName) {
        return "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"username\": \"" + userName + "\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"" + zipcode + "\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
    }

    public static String putPayLoad(String name, String username) {
        String update = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"7000\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        return update;
    }
}
