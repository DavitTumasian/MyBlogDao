package servlet;

import dao.HomeDaoImpl;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("categoryId"));
        HomeDaoImpl homeDao = new HomeDaoImpl();
        List<Post> postByCategory = homeDao.showPostByCategory(id);
        String categoryName = homeDao.getCategoryNameById(id);
        req.setAttribute("postByCategory", postByCategory);
        req.setAttribute("categoryName", categoryName);
        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }
}
