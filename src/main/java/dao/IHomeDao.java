package dao;

import model.Category;
import model.Post;

import java.util.List;

/**
 * Created by User on 15.07.2017.
 */
public interface IHomeDao {
     List<Post> showAllPosts();
     List<Category> showAllCategories();
     List<Post> showPostByCategory(long categoryId);
     String getCategoryNameById(long categoryId);
}
