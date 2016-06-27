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
                    <th>Ordre</th>
                    <th>Titre</th>
                    <th>Réponse 1</th>
                    <th>Réponse 2</th>
                    <th>Réponse 3</th>
                    <th>Réponse 4</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${question.ordre}</td>
                    <td>${question.titre}</td>
                    <td><label for="rep1">${question.rep1}</label>
                        <input name="rep1" type="radio"></td>
                    <td><label for="rep2">${question.rep2}</label>
                        <input name="rep2" type="radio"></td>
                    <td><label for="rep3">${question.rep3}</label>
                        <input name="rep3" type="radio"></td>
                    <td><label for="rep4">${question.rep4}</label>
                         <input name="rep4" type="radio"></td>
                    <td><input type="submit" value="Valider votre réponse"></td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="pied">
        <c:import url="_PIED.jsp"/>
    </div>
</body>
</html>
