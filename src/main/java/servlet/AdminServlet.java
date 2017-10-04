package servlet;


import dao.AdminDaoImpl;
import model.Category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("admin") != null) {
            AdminDaoImpl adminDao = new AdminDaoImpl();
            List<Category> categories = adminDao.getAllCategories();
            req.setAttribute("allCategories", categories);
            req.getRequestDispatcher("admin.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("login.jsp");
        }

    }
}
