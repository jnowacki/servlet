package pl.jnowacki;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<html>");

        if (req.getSession().getAttribute("isLoggedIn") != null
                && (boolean)req.getSession().getAttribute("isLoggedIn")) {

            out.println("Hi " + req.getSession().getAttribute("name"));
            out.println("<br>You are logged in<br>");
            out.println("This page is only visible for logged in users<br>");
            out.println("<a href=\"logout\">click for logout</a>");

        } else {
            out.println("Please log in");
        }

        out.println("</html>");
    }
}
