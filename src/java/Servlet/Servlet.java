package Servlet;

import br.cesjf.lpwsd.dao.AlunoJpaController;
import classe.Aluno;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet", "/cadastrarAluno.html", "/listarAlunos.html"})
public class Servlet extends HttpServlet {

    @PersistenceUnit(unitName = "PDWSDExercicio1PU")
    EntityManagerFactory emf;
    @Resource(name = "java:comp/UserTransaction")
    UserTransaction ut;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String uri = request.getRequestURI();
        //String _senha = request.getParameter("senha");

        if (uri.contains("cadastrarAluno.html")) {
            request.getRequestDispatcher("/WEB-INF/addAluno.jsp").forward(request, response);
        }else if (uri.contains("listarAlunos.html")){
            listAll(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("cadastrarAluno.html")) {
            String nome = request.getParameter("nome");
            String idade = request.getParameter("idade");
            //Boolean sexo = Boolean.parseBoolean(request.getParameter("sexo"));
            Integer matricula = Integer.parseInt(request.getParameter("matricula"));
            Date inscricao = new Date();

            Aluno a = new Aluno();
            a.setNome(nome);
            a.setMatricula(matricula);
            a.setIdade(idade);

            AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            try {
                System.out.println("persistindo " + a);
                daoAluno.create(a);
                System.out.println("persistido " + a);
                List<Aluno> alunos = daoAluno.findAlunoEntities();
                System.out.println(alunos);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("listarAlunos.html");
        }
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
        List<Aluno> alunos = daoAluno.findAlunoEntities();
        System.out.println(alunos);
        request.setAttribute("alunos", alunos);
        request.getRequestDispatcher("/WEB-INF/listarAlunos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
