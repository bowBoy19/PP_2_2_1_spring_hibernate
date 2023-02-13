package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      carService.add(new Car("Lada", 7, new User("User1", "Lastname1", "user1@mail.ru")));
      carService.add(new Car("Volga", 1, new User("User2", "Lastname2", "user2@mail.ru")));
      carService.add(new Car("Tesla", 1, new User("User3", "Lastname3", "user3@mail.ru")));
      carService.add(new Car("Toyota", 2, new User("User4", "Lastname4", "user4@mail.ru")));

      userService.getUserByCarModelAndSeries("Lada",7);
      context.close();

   }

}

