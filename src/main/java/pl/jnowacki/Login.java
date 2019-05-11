package pl.jnowacki;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<html>");

        String requiredName = "user";
        String requiredPassword = "pwd";

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if(!requiredName.equals(name) || !requiredPassword.equals(password)) {
            out.println("name or password invalid<br>");
            out.println("<a href=\"" + req.getContextPath() + "\">click for login page</a>");
        } else {
            req.getSession().setAttribute("isLoggedIn", true);
            req.getSession().setAttribute("name", name);

            out.println("Hi " + req.getSession().getAttribute("name") + " you are now logged in<br>");
            out.println("<a href=\"home\">click for home page</a><br>");
            out.println("<a href=\"logout\">click for logout</a>");
        }

        out.println("</html>");
    }
}
