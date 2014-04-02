package org.tarascar.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExitServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        Boolean isAccessAllowed = (Boolean) req.getSession(true).getAttribute("isAccessAllowed");
        isAccessAllowed = false;
        req.getSession(true).setAttribute("isAccessAllowed", false);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }


}
