package SimplifyNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotificationMain {
    public static void main(String[] args) throws Exception{
            System.out.println("Hello from Spring");
        SpringApplication.run(NotificationMain.class, args);
    }
}
