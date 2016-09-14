/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.dao.exceptions.NonexistentEntityException;
import br.cesjf.lpwsd.dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import classe.Aluno;
import classe.Grupo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author aluno
 */
public class GrupoJpaController implements Serializable {

    public GrupoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Grupo grupo) throws RollbackFailureException, Exception {
        if (grupo.getAlunos() == null) {
            grupo.setAlunos(new ArrayList<Aluno>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Aluno> attachedAlunos = new ArrayList<Aluno>();
            for (Aluno alunosAlunoToAttach : grupo.getAlunos()) {
                alunosAlunoToAttach = em.getReference(alunosAlunoToAttach.getClass(), alunosAlunoToAttach.getId());
                attachedAlunos.add(alunosAlunoToAttach);
            }
            grupo.setAlunos(attachedAlunos);
            em.persist(grupo);
            for (Aluno alunosAluno : grupo.getAlunos()) {
                Grupo oldGrupoOfAlunosAluno = alunosAluno.getGrupo();
                alunosAluno.setGrupo(grupo);
                alunosAluno = em.merge(alunosAluno);
                if (oldGrupoOfAlunosAluno != null) {
                    oldGrupoOfAlunosAluno.getAlunos().remove(alunosAluno);
                    oldGrupoOfAlunosAluno = em.merge(oldGrupoOfAlunosAluno);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Grupo grupo) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Grupo persistentGrupo = em.find(Grupo.class, grupo.getId());
            List<Aluno> alunosOld = persistentGrupo.getAlunos();
            List<Aluno> alunosNew = grupo.getAlunos();
            List<Aluno> attachedAlunosNew = new ArrayList<Aluno>();
            for (Aluno alunosNewAlunoToAttach : alunosNew) {
                alunosNewAlunoToAttach = em.getReference(alunosNewAlunoToAttach.getClass(), alunosNewAlunoToAttach.getId());
                attachedAlunosNew.add(alunosNewAlunoToAttach);
            }
            alunosNew = attachedAlunosNew;
            grupo.setAlunos(alunosNew);
            grupo = em.merge(grupo);
            for (Aluno alunosOldAluno : alunosOld) {
                if (!alunosNew.contains(alunosOldAluno)) {
                    alunosOldAluno.setGrupo(null);
                    alunosOldAluno = em.merge(alunosOldAluno);
                }
            }
            for (Aluno alunosNewAluno : alunosNew) {
                if (!alunosOld.contains(alunosNewAluno)) {
                    Grupo oldGrupoOfAlunosNewAluno = alunosNewAluno.getGrupo();
                    alunosNewAluno.setGrupo(grupo);
                    alunosNewAluno = em.merge(alunosNewAluno);
                    if (oldGrupoOfAlunosNewAluno != null && !oldGrupoOfAlunosNewAluno.equals(grupo)) {
                        oldGrupoOfAlunosNewAluno.getAlunos().remove(alunosNewAluno);
                        oldGrupoOfAlunosNewAluno = em.merge(oldGrupoOfAlunosNewAluno);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = grupo.getId();
                if (findGrupo(id) == null) {
                    throw new NonexistentEntityException("The grupo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Grupo grupo;
            try {
                grupo = em.getReference(Grupo.class, id);
                grupo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The grupo with id " + id + " no longer exists.", enfe);
            }
            List<Aluno> alunos = grupo.getAlunos();
            for (Aluno alunosAluno : alunos) {
                alunosAluno.setGrupo(null);
                alunosAluno = em.merge(alunosAluno);
            }
            em.remove(grupo);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Grupo> findGrupoEntities() {
        return findGrupoEntities(true, -1, -1);
    }

    public List<Grupo> findGrupoEntities(int maxResults, int firstResult) {
        return findGrupoEntities(false, maxResults, firstResult);
    }

    private List<Grupo> findGrupoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Grupo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Grupo findGrupo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Grupo.class, id);
        } finally {
            em.close();
        }
    }

    public int getGrupoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Grupo> rt = cq.from(Grupo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
