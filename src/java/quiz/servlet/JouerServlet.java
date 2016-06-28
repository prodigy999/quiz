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
@WebServlet(name = "JouerServlet", urlPatterns = {"/jouer_quiz"})
public class JouerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
       long IDQuiz = (long) req.getSession().getAttribute("IdQuizActuel");
       List<Question> quest = new QuestionService().listerParId(IDQuiz);
       
       req.setAttribute("quiz", quest);
       
       req.getSession().setAttribute("ordreQuest", 0);
       req.getSession().setAttribute("score", 0);
       
       resp.sendRedirect("question_suivante");
    }
}
