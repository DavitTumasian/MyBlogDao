package dao;


import model.User;

public interface IUserDao {

    public User getUserByUsernamePassword(String username, String password);

}
