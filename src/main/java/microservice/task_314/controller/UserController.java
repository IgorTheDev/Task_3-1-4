package microservice.task_314.controller;


import microservice.task_314.model.User;
import microservice.task_314.service.APIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final APIClient client;
    private final String url = "http://94.198.50.185:7081/api/users";

    @Autowired
    public UserController(APIClient client) {
        this.client = client;
    }

    @GetMapping()
    public String getData() {
        return client.getData(url);
    }

    @PostMapping()
    public String postData(@RequestBody User user) {
        return client.postData(url, user);
    }

    @PutMapping()
    public String putData(@RequestBody User user) {
        return client.putData(url, user);
    }

    @DeleteMapping()
    public String deleteData(@RequestBody long id) {
        return client.deleteData(url, id);
    }

    @GetMapping("/request")
    public String request() {
        User james = new User(3L,"James","Brown", (byte) 30);
        User thomas = new User(3L,"Thomas","Shelby", (byte) 35);
        getData();
        String req1=postData(james);
        String req2=putData(thomas);
        String req3=deleteData(3L);
        return req1+req2+req3;
    }
}
