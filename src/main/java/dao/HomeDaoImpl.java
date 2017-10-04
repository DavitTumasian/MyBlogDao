package dao;

import model.Category;
import model.Post;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by User on 15.07.2017.
 */
public class HomeDaoImpl implements IHomeDao {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public List<Post> showAllPosts() {
        String hql = "from Post p";
        List<Post> postList = (List<Post>) session.createQuery(hql).list();
        return postList;
    }

    public List<Category> showAllCategories() {
        String hql = "from Category c";
        List<Category> categoryList = (List<Category>) session.createQuery(hql).list();
        return categoryList;
    }

    public List<Post> showPostByCategory(long categoryId) {
        String hql = "from Post p where p.category_id = :id";
        List<Post> postList = (List<Post>) session.createQuery(hql).setParameter("id", categoryId).list();
        return postList;
    }

    public String getCategoryNameById(long categoryId) {
        String hql = "from Category c where c.id= :id";
        Category category = (Category) session.createQuery(hql).setParameter("id", categoryId).uniqueResult();
        String categoryName = category.getName();
        return categoryName;
    }
}
