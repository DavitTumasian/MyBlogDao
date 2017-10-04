package dao;

import model.Category;
import model.Post;

public interface IAdminDao {

    void addCategory(Category category);
    void addPost(Post post);

}
