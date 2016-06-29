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
import quiz.entity.Quiz;

/**
 *
 * @author admin
 */
public class QuizDAO {
    
    public List<Quiz> listerTous() {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        return em.createQuery("SELECT q FROM Quiz q").getResultList();
    }

    public Quiz rechercheParID(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        return em.find(Quiz.class, id);
    }
    
    public void ajouterQuiz(Quiz q) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        em.persist(q);

        em.getTransaction().commit();
    }

    public void supprimerQuiz(long id) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        Query q = em.createQuery("DELETE FROM Quiz WHERE q.id=:idquiz");
        q.setParameter("idquiz", id);
        q.executeUpdate();

        em.getTransaction().commit();
    }

    public void modifierQuiz(Quiz q) {

        EntityManager em = Persistence.createEntityManagerFactory("QuizPU").createEntityManager();
        em.getTransaction().begin();

        em.merge(q);

        em.getTransaction().commit();
    }
    
}
