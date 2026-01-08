 
package controller;

import dal.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Login;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        if (username == null || !username.matches("[a-zA-Z0-9_]+")) {
    request.setAttribute("msg", "Invalid username");
    request.getRequestDispatcher("index.jsp").forward(request, response);
    return; // DỪNG LOGIN
}
        HttpSession session = request.getSession();
        LoginDAO dao = new LoginDAO();
        List<Login> list = dao.getListLogin();
        for (Login l : list) {
            if (username.equals(l.getUsername()) && password.equals(l.getPassword())) {
                if (remember != null) {
                    Cookie ck = new Cookie("username", username);
                    ck.setMaxAge(60);
                    response.addCookie(ck);
                }

                session.setAttribute("username", username);
                response.sendRedirect("home.jsp");
                return ;
            }
        }
        String msg ="sai password hoặc username ";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

}
