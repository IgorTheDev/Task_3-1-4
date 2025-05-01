package microservice.task_314;

import microservice.task_314.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;


public class Task314Application {

    public static void main(String[] args) {
        APIClient client = new APIClient();
        String url = "http://94.198.50.185:7081/api/users";


        String firstResponse = client.getData(url);
        System.out.println(firstResponse);

        User james = new User(3L,"James","Brown", (byte) 30);
        String secondResponse = client.postData(url, james);
        System.out.println(client.getDataWithCookie(url)+"\n"+secondResponse);


        String thirdResponse = client.putData(url, new User(3L, "Thomas", "Shelby", (byte) 30));
        System.out.println(client.getDataWithCookie(url)+"\n"+thirdResponse);


        String fourthResponse = client.deleteData(url, 3L);
        System.out.println(client.getDataWithCookie(url)+"\n"+fourthResponse);

        System.out.println("----------------------------------------------------");
        System.out.println(client.getDataWithCookie(url)+"\n"+secondResponse+thirdResponse+fourthResponse);

    }

}
