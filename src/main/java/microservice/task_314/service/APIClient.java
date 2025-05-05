package microservice.task_314.service;

import microservice.task_314.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class APIClient {
    private RestTemplate restTemplate;
    private static String sessionId;


    public APIClient() {
        restTemplate = new RestTemplate();
    }

    public String getData(String url) {
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        sessionId = response.getHeaders().getFirst("Set-Cookie");
        return response.getBody();
    }

    public String getDataWithCookie(String url) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie", sessionId);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

    public String postData(String url, User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        return response.getBody();
    }

    public String putData(String url, User user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionId);
        HttpEntity<User> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
        return response.getBody();
    }

    public String deleteData(String url, Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", sessionId);
        HttpEntity<Long> request = new HttpEntity<>(id, headers);
        String urlDelete = url+"/"+id;
        ResponseEntity<String> response = restTemplate.exchange(urlDelete, HttpMethod.DELETE, request, String.class);
        return response.getBody();
    }


}
