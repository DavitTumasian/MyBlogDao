package dao;


import model.User;
import org.hibernate.Session;
import util.HibernateUtil;



public class UserDaoImpl implements IUserDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public User getUserByUsernamePassword(String username, String password) {
        String hql ="from User u where u.username = :username and u.password = :password";
        User user= (User) session.createQuery(hql).setParameter("username", username
        ).setParameter("password",password).uniqueResult();

       return user;
    }

}
