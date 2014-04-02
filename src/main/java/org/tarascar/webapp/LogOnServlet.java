package org.tarascar.webapp;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOnServlet extends HttpServlet {

    private LoginService loginService;


    @Override
    public void init() throws ServletException {
        super.init();
        loginService = LoginService.getInstance();
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String login = req.getParameter("login");
        String password = req.getParameter("passwords");
        User u = User.getBuilder().withLog(login).withPass(password).build();
        req.getSession(true).setAttribute("user", u);
        if (loginService.isAccessAllowed(u)) {
            req.getSession(true).setAttribute("isAccessAllowed", true);
            resp.sendRedirect("users");
        } else {
            req.getSession(true).setAttribute("isAccessAllowed", false);
            if (!(loginService.isRegisteredLogin(u))) {
                req.getRequestDispatcher("/loginNotFound.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/passwordNotFound.jsp").forward(req, resp);
            }
        }
    }
}
