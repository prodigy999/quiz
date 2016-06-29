/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import quiz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionDAO {
    
    public List<Question> listerParId(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        return em.createQuery("SELECT q FROM Question q WHERE q.quiz.id=:monid").setParameter("monid", id).getResultList();
    }
    
    public List<Question> listerParQuizIdEtOrdreSuperieur(long id, int ordreQuestionPrecedente) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        Query query = em.createQuery("SELECT q FROM Question q WHERE q.quiz.id=:monid AND q.ordre>:monordre ORDER BY q.ordre");
        
        query.setParameter("monid", id);
        query.setParameter("monordre", ordreQuestionPrecedente);
                        
        return query.getResultList();
    }
    
    public long compteQuesiontParQuizId(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        Query query = em.createQuery("SELECT COUNT (q) FROM Question q WHERE q.quiz.id=:monid");
        query.setParameter("monid", id);
        
        return (long) query.getSingleResult();
    }
    
    public List<Question> listerTous() {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        return em.createQuery("SELECT q FROM Question q").getResultList();
    }

    public Question rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        return em.find(Question.class, id);
    }

    public void ajouterQuestion(Question q) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        em.persist(q);

        em.getTransaction().commit();
    }

    public void supprimerQuestion(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("DELETE FROM Question WHERE q.id=:idquestion");
        q.setParameter("idquestion", id);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void modifierQuestion(Question q) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        em.merge(q);

        em.getTransaction().commit();
    }
    
    
    
}
