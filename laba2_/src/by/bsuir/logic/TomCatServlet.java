package by.bsuir.logic;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TomCatServlet extends HttpServlet {

    public void Method(HttpServletRequest req, HttpServletResponse resp)
    {
        String name = req.getParameter("Name");
        req.setAttribute("login", name);
        String brouser=req.getParameter("browser");
        req.setAttribute("browser",brouser);
        String comment=req.getParameter("comment");
        req.setAttribute("comment",comment);
        String path=req.getContextPath();
        req.setAttribute("contextpath",path);
        req.setAttribute("cook",req.getCookies());
        req.setAttribute("authType", req.getAuthType());
        req.setAttribute("headerNames",req.getHeaderNames());
        req.setAttribute("getMethod",req.getMethod());
        req.setAttribute("pathInfo",req.getPathInfo());
        req.setAttribute("PathTranslated",req.getPathTranslated());
        req.setAttribute("QueryString",req.getQueryString());
        req.setAttribute("RemoteUser",req.getRemoteUser());
        req.setAttribute("RequestedSessionId",req.getRequestedSessionId());
        req.setAttribute("RequestURI",req.getRequestURI());
        req.setAttribute("ServletPath",req.getServletPath());
        req.setAttribute("Session",req.getSession().toString());
        forward("/Out.jsp", req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Method(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Method(request,response);


    }

    public void forward(String to, HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(to);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

