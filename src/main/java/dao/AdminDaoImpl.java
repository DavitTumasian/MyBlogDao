package dao;


import model.Category;
import model.Post;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class AdminDaoImpl implements IAdminDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public void addCategory(Category category) {
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    public void addPost(Post post) {
        session.beginTransaction();
        session.save(post);
        session.getTransaction().commit();
    }



    public long getCategoryIdByName(String categoryNamePost) {

        String hql = "from Category c where c.name = :name";
        Category category = (Category) session.createQuery(hql).setParameter("name", categoryNamePost).uniqueResult();
        long id= category.getId();
        return id;
    }

    public List<Category> getAllCategories() {
        String hql = "from Category c";
        List<Category> categories = session.createQuery(hql).list();
        return categories;
    }
}
