package servlet;

import dao.AdminDaoImpl;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 12.07.2017.
 */
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AdminDaoImpl adminDao = new AdminDaoImpl();
        String categoryName = req.getParameter("categoryName");
        if (categoryName != null) {
            Category category = new Category();
            category.setName(categoryName);
            adminDao.addCategory(category);
            req.getSession().setAttribute("categoryMessage", "Category is added.");
            resp.sendRedirect("/admin");
        }else{
            req.getSession().setAttribute("categoryMessage", "Please input category name.");
            resp.sendRedirect("/admin");
        }
    }
}
