package servlet;


import dao.UserDaoImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getUserByUsernamePassword(username, password);
        if (user != null) {
            req.getSession().setAttribute("admin", "user");
            resp.sendRedirect("/admin");
        } else {
            req.getSession().setAttribute("message", "Incorrect login or password.");
            resp.sendRedirect("/admin");
        }
    }
}
