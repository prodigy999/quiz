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
@WebServlet(name = "QuizServlet", urlPatterns = {"/quiz_page"})
public class QuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       long IDQuiz = Long.parseLong(req.getParameter("idQuiz"));
       Quiz detailQuiz = new QuizService().rechercheParID(IDQuiz);
       req.setAttribute("quiz", detailQuiz);
       req.getRequestDispatcher("questions_quiz.jsp").forward(req, resp);
    }

    

}
