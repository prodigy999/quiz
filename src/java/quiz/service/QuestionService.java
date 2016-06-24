/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.service;

import java.util.List;
import quiz.DAO.QuestionDAO;
import quiz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    public List<Question> listerTous() {

        QuestionDAO dao = new QuestionDAO();
        return dao.listerTous();
    }

    public Question rechercheParID(long id) {

        QuestionDAO dao = new QuestionDAO();
        return dao.rechercheParID(id);
    }

    public void ajouterQuestion(Question q) {

        new QuestionDAO().ajouterQuestion(q);

    }

    public void supprimerQuestion(long id) {

        new QuestionDAO().supprimerQuestion(id);
    }
    
    public void modifierQuestion(Question q) {
        
        new QuestionDAO().modifierQuestion(q);
    }
    
}
