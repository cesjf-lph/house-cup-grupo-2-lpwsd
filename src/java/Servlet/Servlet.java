package Servlet;

import br.cesjf.lpwsd.dao.AlunoJpaController;
import br.cesjf.lpwsd.dao.GrupoJpaController;
import br.cesjf.lpwsd.dao.HistoricoJpaController;
import br.cesjf.lpwsd.dao.ProfessorJpaController;
import classe.Aluno;
import classe.Grupo;
import classe.Historico;
import classe.Professor;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet", "/cadastrarAluno.html", "/listarAlunos.html", "/pontuar.html", "/remover.html", "/cadastrarProfessor.html", "/listarProfessores.html", "/listarHistoricos.html", "/pesquisar.html", "/listarTotal.html", "/listarPorPeriodo.html"})
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
        GrupoJpaController daoGrupo = new GrupoJpaController(ut, emf);
        if (daoGrupo.findGrupoEntities().isEmpty()) {
            Grupo g1 = new Grupo();
            g1.setNumero(1);
            try {
                daoGrupo.create(g1);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Grupo g2 = new Grupo();
            g2.setNumero(2);
            try {
                daoGrupo.create(g2);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Grupo g3 = new Grupo();
            g3.setNumero(3);
            try {
                daoGrupo.create(g3);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            Grupo g4 = new Grupo();
            g4.setNumero(4);
            try {
                daoGrupo.create(g4);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (uri.contains("cadastrarAluno.html")) {
            List<Grupo> grupos = daoGrupo.findGrupoEntities();
            request.setAttribute("grupos", grupos);
            request.getRequestDispatcher("/WEB-INF/addAluno.jsp").forward(request, response);
        } else if (uri.contains("listarAlunos.html")) {
            listAll(request, response);
        } else if (uri.contains("listarProfessores.html")) {
            listAllP(request, response);
        } else if (uri.contains("listarHistoricos.html")) {
            listAllH(request, response);
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
        } else if (uri.contains("listarTotal.html")) {
            HistoricoJpaController daoHist = new HistoricoJpaController(ut, emf);
            List<Object[]> ol = daoHist.getHistoricoCount2();
            /*for (Object[] linha : ol) {
                System.out.println(((Grupo)linha[0]).getNumero()+" "+linha[1]);
                
            }*/
            request.setAttribute("grupo", ol);
            request.getRequestDispatcher("/WEB-INF/listarPontos.jsp").forward(request, response);
        } else if (uri.contains("pesquisar.html")) {
            List<String> datas = new ArrayList();
            Integer anoatual = Calendar.getInstance().get(Calendar.YEAR);
            ArrayList<String> datasE = new ArrayList<String>();

            for (int i = 2014; i <= anoatual; i++) {
//                Calendar primeiroSemestre = Calendar.getInstance();
//                primeiroSemestre.get(Calendar.YEAR);
//                primeiroSemestre.clear();
//                primeiroSemestre.set(i, Calendar.JANUARY, 1);
                datasE.add("01/01/" + i);
                datasE.add("01/07/" + i);
//                datasE.add(primeiroSemestre.getTime());
//                Calendar segundoSemestre = Calendar.getInstance();
//                segundoSemestre.set(i, Calendar.JULY, 1,0,0,0);
//                //segundoSemestre.set(Calendar.MONTH, 6);
//                datasE.add(segundoSemestre.getTime());
//                datas.add(segundoSemestre);
            }
            //datasE.get(1).getYear();

            request.setAttribute("anoAt", anoatual);
            request.setAttribute("datas", datasE);
            request.getRequestDispatcher("/WEB-INF/pesquisarPeriodo.jsp").forward(request, response);
        } else if (uri.contains("listarPorPeriodo.html")) {

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
            //Integer grupo = Integer.parseInt(request.getParameter("grupo"));

            Aluno a = new Aluno();
            a.setNome(nome);
            a.setMatricula(matricula);
            GrupoJpaController daoGrupo = new GrupoJpaController(ut, emf);
            a.setGrupo(daoGrupo.findGrupo(Long.parseLong(request.getParameter("grupo"))));

            //a.setGrupo();
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
            //String professor = request.getParameter("professor");
            Long idAluno = Long.parseLong(request.getParameter("aluno"));
            Long idProfessor = Long.parseLong(request.getParameter("professor"));
            Integer pontos = Integer.parseInt(request.getParameter("pontos"));
            String descricao = request.getParameter("descricao");
            AlunoJpaController daoAluno = new AlunoJpaController(ut, emf);
            ProfessorJpaController daoProfessor = new ProfessorJpaController(ut, emf);
            Date data = new Date();
            Historico h = new Historico();
            h.setAluno(daoAluno.findAluno(idAluno));
            h.setProfessor(daoProfessor.findProfessor(idProfessor));
            h.setPontos(pontos);
            h.setDescricao(descricao);
            h.setData(data);
            HistoricoJpaController daoHist = new HistoricoJpaController(ut, emf);
            try {
                daoHist.create(h);
            } catch (Exception ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*List<Object[]> ol = daoHist.getHistoricoCount2();
            for (Object[] linha : ol) {
                System.out.println(((Grupo)linha[0]).getNumero()+" "+linha[1]);
                
            }*/
            response.sendRedirect("listarHistoricos.html");
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
        } else if (request.getRequestURI().contains("cadastrarProfessor.html")) {
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
        } else if (request.getRequestURI().contains("pesquisar.html")) {
            Integer periodo = Integer.parseInt(request.getParameter("pesquisa"));
            HistoricoJpaController daoHist = new HistoricoJpaController(ut, emf);
            List<Calendar> datas = new ArrayList();
            Integer anoatual = Calendar.getInstance().get(Calendar.YEAR);

            for (int i = 2014; i <= anoatual; i++) {
                Calendar primeiroSemestre = Calendar.getInstance();
                primeiroSemestre.clear();
                primeiroSemestre.set(i, Calendar.JANUARY, 1);
                datas.add(primeiroSemestre);
                Calendar segundoSemestre = Calendar.getInstance();
                segundoSemestre.set(i, Calendar.JULY, 1, 0, 0, 0);
                //segundoSemestre.set(Calendar.MONTH, 6);
                datas.add(segundoSemestre);
            }
            ArrayList<Date> datasE = new ArrayList<Date>();
            //Calendar Semestre1 = Calendar.getInstance();
            //Calendar Semestre2 = Calendar.getInstance();
            for (int i = 0; i < datas.size() - 1; i += 2) {

                if (periodo == i) {
                    //Semestre1 = datas.get(i);
                    //Semestre2 = datas.get(i+1);
                    datasE.add(datas.get(i).getTime());
                    datasE.add(datas.get(i + 1).getTime());
                    List<Object[]> ol = daoHist.getHistoricoCount3(datasE.get(0), datasE.get(1));
                    request.setAttribute("grupo", ol);
                }

            }

            //for (Calendar data : datas) {
            //System.out.println(data.getTime());
            //System.out.println(datasE.get(0));
            //System.out.println(datasE.get(1));
            //System.out.println(Semestre2.getTime());
            //}
            request.getRequestDispatcher("/WEB-INF/listarPontos.jsp").forward(request, response);

            //response.sendRedirect("listarPorPeriodo.html");
            //List<Object[]> ol = daoHist.getHistoricoCount3();
        } else if (request.getRequestURI().contains("listarPorPeriodo.html")) {
            String periodo = request.getParameter("periodos");
            DateFormat df = DateFormat.getDateInstance();
            System.out.println(periodo);
            // DateFormat df = DateFormat.get;
            try {
                Date data = df.parse(periodo);
                System.out.println(data);
                Calendar c = Calendar.getInstance();
                c.setTime(data);
                c.add(Calendar.MONTH, 6);
                Date finaldata = c.getTime();
                System.out.println(finaldata);
                HistoricoJpaController dao = new HistoricoJpaController(ut, emf);
                List<Object[]> x = dao.getHistoricoCount3(data, finaldata);
                request.setAttribute("grupo", x);
                request.getRequestDispatcher("/WEB-INF/listarPontos.jsp").forward(request, response);
                
            } catch (ParseException ex) {
                Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
            }

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

    private void listAllH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HistoricoJpaController daoHist = new HistoricoJpaController(ut, emf);
        List<Historico> historicos = daoHist.findHistoricoEntities();
        System.out.println(historicos);
        request.setAttribute("historicos", historicos);
        request.getRequestDispatcher("/WEB-INF/listarHistoricos.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
