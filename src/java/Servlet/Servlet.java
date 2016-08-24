package Servlet;

import java.io.IOException;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet", "cadastrarAluno.html"})
public class Servlet extends HttpServlet {

   @PersistenceUnit 
   (unitName="PDWSDExercicio1PU")
   EntityManagerFactory emf;
   @Resource(name="java:comp/UserTransaction")
   UserTransaction ut;
    
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
