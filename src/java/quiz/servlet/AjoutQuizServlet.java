/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import quiz.entity.Quiz;
import quiz.service.QuizService;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjoutQuizServlet", urlPatterns = {"/ajout_quiz"})
public class AjoutQuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Quiz newQuiz = new Quiz();
        newQuiz.setNom(req.getParameter("nom"));
        
        new QuizService().ajouterQuiz(newQuiz);
        
        resp.sendRedirect("ajout_questions");

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("ajout_quiz.jsp").forward(req, resp);
    }
    
    

}
