package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NovoServlet", urlPatterns = {"/NovoServlet"})
public class NovoServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String _senha=request.getParameter("senha");
        
        if(_senha.equals("123")){
         RequestDispatcher req =request.getRequestDispatcher("/WEB-INF/index.html");
             req.forward(request, response);
        }
        else{
         RequestDispatcher req =request.getRequestDispatcher("/WEB-INF/erro.html");
             req.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
