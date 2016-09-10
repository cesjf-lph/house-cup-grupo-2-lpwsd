package Servlet;

import br.cesjf.lpwsd.dao.AlunoJpaController;
import br.cesjf.lpwsd.dao.HistoricoJpaController;
import br.cesjf.lpwsd.dao.ProfessorJpaController;
import classe.Aluno;
import classe.Historico;
import classe.Professor;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet", "/cadastrarAluno.html", "/listarAlunos.html", "/pontuar.html", "/remover.html", "/cadastrarProfessor.html", "/listarProfessores.html"})
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
        } else if (uri.contains("listarAlunos.html")) {
            listAll(request, response);
        } else if (uri.contains("listarProfessores.html")) {
            listAllP(request, response);
        } else if (uri.contains("cadastrarProfessor.html")) {
            request.getRequestDispatcher("/WEB-INF/addProfessor.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("pontuar.html")) {
            ProfessorJpaController daoProf = new ProfessorJpaController(ut, emf);
            List<Professor> profs = daoProf.findProfessorEntities();
            request.setAttribute("profs", profs);
            AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            List<Aluno> alus = daoAluno.findAlunoEntities();
            request.setAttribute("alus", alus);
            request.getRequestDispatcher("/WEB-INF/pontuarAluno.jsp").forward(request, response);
        } else if (request.getRequestURI().contains("remover.html")) {
            request.setAttribute("id", request.getParameter("id"));
            request.getRequestDispatcher("/WEB-INF/pontuarAluno.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getRequestURI().contains("cadastrarAluno.html")) {
            String nome = request.getParameter("nome");
            //String idade = request.getParameter("idade");
            //Boolean sexo = Boolean.parseBoolean(request.getParameter("sexo"));
            Integer matricula = Integer.parseInt(request.getParameter("matricula"));
            //Date inscricao = new Date();

            Aluno a = new Aluno();
            a.setNome(nome);
            a.setMatricula(matricula);
            //a.setIdade(idade);

            AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            try {
                //System.out.println("persistindo " + a);
                daoAluno.create(a);
                //System.out.println("persistido " + a);
                List<Aluno> alunos = daoAluno.findAlunoEntities();
                //System.out.println(alunos);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("listarAlunos.html");
        } else if (request.getRequestURI().contains("pontuar.html")) {
            /*AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            Aluno alunoE = daoAluno.findAluno(Long.parseLong(request.getParameter("id")));
            alunoE.setPontos(alunoE.getPontos() + Integer.parseInt(request.getParameter("pontos")));
            try {
                daoAluno.edit(alunoE);
            } catch (RollbackFailureException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            String professor = request.getParameter("professor");
            Long idAluno = Long.parseLong(request.getParameter("aluno"));
            Long idProfessor = Long.parseLong(request.getParameter("professor"));
            Integer pontos = Integer.parseInt(request.getParameter("pontos"));
            String descricao = request.getParameter("descricao");
            AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            ProfessorJpaController daoProfessor = new ProfessorJpaController(ut, emf);
            
            Historico h = new Historico();
            h.setAluno(daoAluno.findAluno(idAluno));
            h.setProfessor(daoProfessor.findProfessor(idProfessor));
            h.setPontos(pontos);
            h.setDescricao(descricao);
            HistoricoJpaController daoHist = new HistoricoJpaController(ut, emf);
            try {
                daoHist.create(h);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("listarAlunos.html");
        } else if (request.getRequestURI().contains("remover.html")) {
            /*AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            Aluno alunoE = daoAluno.findAluno(Long.parseLong(request.getParameter("id")));
            if (alunoE.getPontos() > 0) {
                alunoE.setPontos(alunoE.getPontos() - Integer.parseInt(request.getParameter("pontos")));
                try {
                    daoAluno.edit(alunoE);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }*/
            response.sendRedirect("listarAlunos.html");
        }
        else if (request.getRequestURI().contains("cadastrarProfessor.html")){
            String nome = request.getParameter("nome");
            
            Professor p = new Professor();
            //a.setIdade(idade);
            p.setNome(nome);
            ProfessorJpaController daoProf = new ProfessorJpaController(ut, emf);
            try {
                //System.out.println("persistindo " + a);
                daoProf.create(p);
                //System.out.println("persistido " + a);
                //List<Aluno> alunos = daoAluno.findAlunoEntities();
                //System.out.println(alunos);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("listarProfessores.html");
        }
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
        List<Aluno> alunos = daoAluno.findAlunoEntities();
        System.out.println(alunos);
        request.setAttribute("alunos", alunos);
        request.getRequestDispatcher("/WEB-INF/listarAlunos.jsp").forward(request, response);
    }
    
    private void listAllP(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ProfessorJpaController daoProf = new ProfessorJpaController(ut, emf);
       List<Professor> professores = daoProf.findProfessorEntities();
       System.out.println(professores);
       request.setAttribute("professores", professores);
       request.getRequestDispatcher("/WEB-INF/listarProfessores.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
