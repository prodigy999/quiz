/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.service;

import java.util.List;
import quiz.dao.QuestionDAO;
import quiz.entity.Question;

/**
 *
 * @author admin
 */
public class QuestionService {
    
    /**
     * 
     * @param quizId
     * @param ordreQuestionPrecedente : vaut zero si pas repondu
     * @return 
     */
    public Question rechercherQuestionSuivante (long quizId, int ordreQuestionPrecedente){
        
        QuestionDAO questionDAO = new QuestionDAO();
        
        //recup nombre de question du quiz
        long nbQuestionQuiz = questionDAO.compteQuesiontParQuizId(quizId);
        
        //verifie si vide => exception
        if (nbQuestionQuiz == 0){
            throw new RuntimeException ("Le quiz est vide !");
        }
        
        //le quiz n'est pas vide
        //liste les questions suivantes de mon quiz trié par ordre croissant
        List <Question> questionSuivante = questionDAO.listerParQuizIdEtOrdreSuperieur(quizId, ordreQuestionPrecedente);
        
        //verifie si reste des questions => return null
        if (questionSuivante.size() == 0){
            return null;
        }
        
        // ma liste n'est pas vide donc j'envoie la question suivante
        return  questionSuivante.get(0);
    }
    
    public List<Question> listerParId(long id) {

        QuestionDAO dao = new QuestionDAO();
        return dao.listerParId(id);
    }
    
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
