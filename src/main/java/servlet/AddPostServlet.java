package servlet;

import dao.AdminDaoImpl;
import model.Post;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class AddPostServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        AdminDaoImpl adminDao = new AdminDaoImpl();
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(50 * 1024);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(9900 * 1024);
            try {
                List<FileItem> fileItems = upload.parseRequest(req);
                Post post = new Post();
                for (FileItem fi : fileItems) {
                    if (!fi.isFormField()) {
                        String fileName = fi.getName();
                        File file = new File(Constant.IMAGE_UPLOAD_FOLDER +
                                "file_" + System.currentTimeMillis() + fileName);
                        fi.write(file);
                        post.setImage(file.getName());
                    } else if (fi.getFieldName().equals("title")) {
                        post.setTitle(fi.getString());
                    } else if (fi.getFieldName().equals("categoryNamePost")) {
                        post.setCategory_id(adminDao.getCategoryIdByName(fi.getString()));
                    } else if (fi.getFieldName().equals("description")) {
                        post.setDescription(fi.getString());
                    }
                }
                adminDao.addPost(post);
                req.getSession().setAttribute("postMessage", "Post is added.");
                resp.sendRedirect("/admin");
            }catch (Exception e){
                resp.sendRedirect("error.jsp");
                e.printStackTrace();
            }
        }
    }
}