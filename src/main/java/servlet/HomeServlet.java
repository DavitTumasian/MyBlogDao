package servlet;

import dao.HomeDaoImpl;
import model.Category;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by User on 10.07.2017.
 */
public class HomeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeDaoImpl homeDao = new HomeDaoImpl();
        List<Post> postList= homeDao.showAllPosts();
        req.setAttribute("allPosts", postList);
        List<Category> categoryList = homeDao.showAllCategories();
        req.setAttribute("allCategories", categoryList);
        req.getRequestDispatcher("home.jsp").forward(req, resp);
    }
}
