import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

public class Click extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String lv = (String) session.getAttribute("lv");
        if (lv == null) {
            lv = "lv1";
        }
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        } else {
            count++;
        }
        if(count >= 100)
            lv = "lv2";
        if(count >= 300)
            lv = "lv3";
        if(count >= 600)
            lv = "lv4";
        if(count >= 1000)
            response.sendRedirect("/egg/done");
        else{
            session.setAttribute("count", count);
            session.setAttribute("lv", lv);
            request.getRequestDispatcher("/index").forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
