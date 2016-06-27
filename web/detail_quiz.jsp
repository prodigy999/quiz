<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:import url="_STYLESHEET.jsp"/>            
</head>
<body>
    <div class="titre">
        <c:import url="_TITRE.jsp"/>
    </div>
    <div class="menu">
        <c:import url="_MENU.jsp"/>
    </div>
    <div class="contenu">
        <table>
            <thead>
                <tr>
                    <th>Questions Quiz</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                <td>
                <c:forEach items="${quiz.questions}" var="quest">
                    ${quest.ordre} ---> <a href="affiche_question?idQuestion=${quest.id}">${quest.titre}</a>
                    <br>
                </c:forEach>
                </td>
                </tr>                
            </tbody>
        </table>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>
