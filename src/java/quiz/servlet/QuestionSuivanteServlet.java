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
       int ordreDerniereQuestionRepondue = (int) req.getSession().getAttribute("ordreQuest");
       
       Question questionSuivante = new QuestionService().rechercherQuestionSuivante(iDQuiz, ordreDerniereQuestionRepondue);
       req.getSession().setAttribute("ordreQuest", questionSuivante.getOrdre());
       
       if (questionSuivante == null){
           resp.sendRedirect("quiz_page");
       }
       
       req.setAttribute("question", questionSuivante);
       req.getRequestDispatcher("question_suivante.jsp").forward(req, resp);
       
          
       
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        long IDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
        byte rep = (Byte.parseByte(req.getParameter("reponse")));
        
        Question quest = new QuestionService().rechercheParID(IDQuiz);
        
        System.out.println("----------reponse----------------" + rep);
        System.out.println("-----------reponseCorrecte---------------" + quest.getNumRepCorrecte());
        System.out.println("-------------scoreavant-------------" + req.getSession().getAttribute("score"));
        
        if (rep==quest.getNumRepCorrecte()); {
        
            int score = (int) req.getSession().getAttribute("score");
            req.getSession().setAttribute("score", score + 1 );
        }
        
        System.out.println("-------------scoreapres-------------" + req.getSession().getAttribute("score"));
        
        resp.sendRedirect("question_suivante");
    }
}
