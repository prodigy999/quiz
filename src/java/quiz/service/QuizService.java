/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.service;

import java.util.List;
import quiz.dao.QuizDAO;
import quiz.entity.Quiz;

/**
 *
 * @author admin
 */
public class QuizService {
    
     
    public List<Quiz> listerTous() {

        QuizDAO dao = new QuizDAO();
        return dao.listerTous();
    }

    public Quiz rechercheParID(long id) {

        QuizDAO dao = new QuizDAO();
        return dao.rechercheParID(id);
    }

    public void ajouterQuiz(Quiz q) {

        new QuizDAO().ajouterQuiz(q);

    }

    public void supprimerQuiz(long id) {

        new QuizDAO().supprimerQuiz(id);
    }
    
    public void modifierQuiz(Quiz q) {
        
        new QuizDAO().modifierQuiz(q);
    }
    
}
