package servlet;

import util.Constant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by User on 10.07.2017.
 */
public class GetImageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String image = req.getParameter("image");
        if (image != null && image.trim().length() > 0) {
            OutputStream out = resp.getOutputStream();
//            resp.setContentType("image/jpeg");

            resp.setContentType("application/octet-stream");

            resp.setHeader("Content-Disposition", "attachment; filename=\"picture.png\"");
//            resp.se("application/octet-stream");
            FileInputStream in = new FileInputStream(Constant.IMAGE_UPLOAD_FOLDER + image);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        }
    }
}