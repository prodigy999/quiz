/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.entity.Question;
import quiz.entity.Quiz;
import quiz.service.QuestionService;
import quiz.service.QuizService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutQuestionServlet", urlPatterns = {"/ajout_questions"})
public class AjoutQuestionServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long IDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
        Quiz quiz = new QuizService().rechercheParID(IDQuiz);
       
        Question newQuest = new Question();
        
        newQuest.setTitre(req.getParameter("titre"));
        newQuest.setOrdre(Byte.parseByte(req.getParameter("ordre")));
        newQuest.setRep1(req.getParameter("rep1"));
        newQuest.setRep2(req.getParameter("rep2"));
        newQuest.setRep3(req.getParameter("rep3"));
        newQuest.setRep4(req.getParameter("rep4"));
        newQuest.setNumRepCorrecte(Byte.parseByte(req.getParameter("repCorrecte")));
        newQuest.setQuiz(quiz);
        quiz.getQuestions().add(newQuest);
        
        new QuestionService().ajouterQuestion(newQuest);

        resp.sendRedirect("detail_quiz");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getParameter("idQuiz");

        req.getRequestDispatcher("ajout_question.jsp").forward(req, resp);
    }

}
