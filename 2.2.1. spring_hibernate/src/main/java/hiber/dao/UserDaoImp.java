package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


   private SessionFactory sessionFactory;
   public UserDaoImp(SessionFactory sessionFactory){
      this.sessionFactory=sessionFactory;
   }

   @Override
   public User getUserByCarModelAndSeries(String model, int series) {
      Session session = sessionFactory.getCurrentSession();
      Car car = (Car) session.createQuery("FROM Car where model =:pmodel and series =:pseries")
              .setParameter("pmodel", model)
              .setParameter("pseries", series)
              .getSingleResult();
      User user = car.getUser();
      System.out.println(user);

      return user;
   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

}