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
import quiz.service.QuestionService;

/**
 *
 * @author admin
 */
@WebServlet(name = "QuestionSuivante", urlPatterns = {"/question_suivante"})
public class QuestionSuivanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       long iDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
       int ordreQuest = (int) req.getSession().getAttribute("ordreQuest");
       List <Question> quest = new QuestionService().nbrQuestParId(iDQuiz, ordreQuest);
       int taille = quest.size();
       req.setAttribute("quiz", quest);
       
       
       if (quest.size() < 1){
           
           resp.sendRedirect("quiz_page");
       }
       
       else {
          req.getRequestDispatcher("question_suivante.jsp").forward(req, resp); 
       }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        long IDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
        byte rep = (Byte.parseByte(req.getParameter("reponse")));
        
        Question quest = new QuestionService().rechercheParID(IDQuiz);
        
        if (rep==quest.getNumRepCorrecte()); {
            int score = (int) req.getSession().getAttribute("score");
            req.getSession().setAttribute("score", score + 1 );
        }
        
        req.getSession().setAttribute("ordreQuest", quest.getOrdre());
        resp.sendRedirect("question_suivante");
    }
}
