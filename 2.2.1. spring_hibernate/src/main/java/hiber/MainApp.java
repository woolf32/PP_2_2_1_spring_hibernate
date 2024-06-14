package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Вася","Петров","email1@gmail.com");
      User user2 = new User("Иван","Иванов","email2@gmail.com");
      User user3 = new User("Гриша","Смирнов","email3@gmail.com");
      User user4 = new User("Дима","Кутепов","email4@gmail.com");
      User user5 = new User("Толя","Вартанг","email5@gmail.com");

      Car car1 = new Car("ГАЗ",8);
      Car car2 = new Car("ВАЗ",7);
      Car car3 = new Car("МАЗ",4);
      Car car4 = new Car("БМВ",3);
      Car car5 = new Car("МЕРСЕДЕС",2);

      user1.setUserCar(car1);
      user2.setUserCar(car2);
      user3.setUserCar(car3);
      user4.setUserCar(car4);
      user5.setUserCar(car5);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);



      /*List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getUserCar());
         System.out.println();
      }*/

      System.out.println(userService.getUserByCar("БМВ",3));



      context.close();
   }
}
