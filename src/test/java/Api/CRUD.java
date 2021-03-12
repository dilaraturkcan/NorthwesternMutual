package Api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import utils.PayLoads;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CRUD {

    @Test
    public void getTest() throws URISyntaxException, IOException {
        //initialize the client
        HttpClient client = HttpClientBuilder.create().build();

        // Construct URL https://jsonplaceholder.typicode.com
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("jsonplaceholder.typicode.com").setPath("/posts");


        //Define the Http Method
        HttpGet httpGet= new HttpGet(uriBuilder.build());

        //Add parameters
        httpGet.addHeader("accept","application/json");

        //execute a call
        HttpResponse response=client.execute(httpGet);

        Assert.assertEquals(response.getStatusLine().getStatusCode(),200);


    }




    @Test
    public void post() throws URISyntaxException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        // Construct URL https://jsonplaceholder.typicode.com
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https").setHost("jsonplaceholder.typicode.com").setPath("/posts");
        //Define the Http Method
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.addHeader("accept", "application/json");
        httpPost.addHeader("Content-Type", "application/json");
        String postBody = PayLoads.getUserPayload("6000", "umut","yumruk");
        HttpEntity entity = new StringEntity(postBody);
        httpPost.setEntity(entity);
        HttpResponse response = client.execute(httpPost);
        Assert.assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deserializedResponse = objectMapper.readValue(response.getEntity().getContent(), new TypeReference<Map<String, Object>>() {
        });

        Map<String,Object> address=  (Map<String,Object>) deserializedResponse.get("address");

        String zipcode= (String) address.get("zipcode");

        String actualName= (String) deserializedResponse.get("name");

        String actualUserName=(String) deserializedResponse.get("username");


        Assert.assertEquals(zipcode,"6000");
        Assert.assertEquals(actualName,"umut");
       Assert.assertEquals(actualUserName,"yumruk");

        System.out.println(deserializedResponse);
   }

   @Test
   public void put() throws URISyntaxException, IOException {
       HttpClient client= HttpClientBuilder.create().build();
       URIBuilder uriBuilder=new URIBuilder();
       uriBuilder.setScheme("https").setHost("jsonplaceholder.typicode.com").setPath("posts/1");
//       https://jsonplaceholder.typicode.com/posts/1

       HttpPut put=new HttpPut(uriBuilder.build());
       put.addHeader("Accept","application/json");
       put.addHeader("Content-Type","application/json");

       String updatedName="Northwestern";
       String updatedUserName="mutual";
       String putBody= PayLoads.putPayLoad(updatedName,updatedUserName);



       HttpEntity entity=new StringEntity(putBody);
       put.setEntity(entity);
       HttpResponse response= client.execute(put);

       Assert.assertEquals(HttpStatus.SC_OK , response.getStatusLine().getStatusCode());
       Assert.assertTrue(response.getEntity().getContentType().getValue().contains("application/json"));




   }
    @Test
    public void delete(){

        HttpClient client = HttpClientBuilder.create().build();

        // Construct URL https://jsonplaceholder.typicode.com
        URIBuilder uriBuilder=new URIBuilder();
        uriBuilder.setScheme("https").setHost("jsonplaceholder.typicode.com").setPath("/posts");

        HttpDelete delete= null;
        try {
            delete = new HttpDelete(uriBuilder.build());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        delete.addHeader("accept","application/json");

        HttpResponse response= null;
        try {
            response = client.execute(delete);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        int statusCode=response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, HttpStatus.SC_NOT_FOUND);
    }




}
