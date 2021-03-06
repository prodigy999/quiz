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
@WebServlet(name = "DetailQuizServlet", urlPatterns = {"/detail_quiz"})
public class DetailQuizServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
       long IDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
       List<Question> quest = new QuestionService().listerParId(IDQuiz);
       req.setAttribute("quiz", quest);
       req.getRequestDispatcher("detail_quiz.jsp").forward(req, resp);
    }
    
    

    

}
