package microservice.task_314;

import microservice.task_314.model.User;
import microservice.task_314.service.APIClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Task314Application {

    public static void main(String[] args) {
        SpringApplication.run(Task314Application.class, args);
    }
}
