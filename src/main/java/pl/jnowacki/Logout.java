package pl.jnowacki;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<html>");

        if(req.getSession().getAttribute("isLoggedIn") == null
                || !(boolean)req.getSession().getAttribute("isLoggedIn")) {
            out.println("you are not logged in, can not log out");
        } else {
            req.getSession().invalidate();
            out.println("You are now logged out");
        }

        out.println("<br><a href=\"" + req.getContextPath() + "\">click for login page</a>");
        out.println("</html>");
    }
}
