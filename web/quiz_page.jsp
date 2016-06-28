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
                    <th>Titre Quiz</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${quizs}" var="quiz">
                    <tr>
                        <td><a href=mettre_en_session_quizz_act?id=${quiz.id}>${quiz.nom}</a></td>
                    </tr>
                </c:forEach> 
                <c:if test="${UtilConnecte=='admin'}">
                        <td><a href="ajout_quiz">Ajouter Quiz</a></td>
                </c:if>
            </tbody>
        </table>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>
