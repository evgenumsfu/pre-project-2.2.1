package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Darya", "Lastname1", "user1@mail.ru",(new Car("Mazda cx-5",2015))));
      userService.add(new User("Evgeniy", "Lastname2", "user2@mail.ru",(new Car("Toyota rav-4",2008))));
      userService.add(new User("Valentin", "Lastname3", "user3@mail.ru",(new Car("Renault Logan",2011))));
      userService.add(new User("Pavel", "Lastname4", "user4@mail.ru",(new Car("Hyundai Santa Fe",2010))));

      List<User> users = userService.listGetUser("Mazda cx-5", 2015);
      for (User user : users) {
         System.out.println(user);
      }
      context.close();
   }
}