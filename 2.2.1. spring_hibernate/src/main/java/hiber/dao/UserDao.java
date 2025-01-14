package hiber.dao;

import hiber.model.User;

import javax.persistence.Query;
import java.util.List;

public interface UserDao {
   User getUserByCarModelAndSeries(String model, int series);

   void add(User user);

   List<User> listUsers();
}