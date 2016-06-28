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
                    <th>Détail question</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                <td>
                <c:forEach items="${quiz}" var="quest">
                     ${quest.ordre} ---> ${quest.titre}
                            
                    <br>
                </c:forEach>
                <a href="jouer_quiz"> Jouer</a>
                <c:if test="${UtilConnecte=='admin'}">
                        <a href="ajout_questions">Ajouter Qestions</a>
                </c:if>
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
