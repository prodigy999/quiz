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
            <h1>Ajouter Question</h1>
            <form method="post">
                <label for="ordre">Ordre question dans le quiz :</label>
                <input name="ordre" type="text" width="150">
                <br />
                <br />
                <label for="titre">Titre :</label>
                <input name="titre" type="text" width="150">
                <br />
                <br />
                <label for="rep1">Réponse 1 :</label>
                <input name="rep1" type="text" width="150"><input name="repCorrecte" type="radio" checked="checked" value="1">
                <br />
                <br />
                <label for="rep2">Réponse 2 :</label>
                <input name="rep2" type="text" width="150"><input name="repCorrecte" type="radio" value="2">
                <br />
                <br />
                <label for="rep3">Réponse 3 :</label>
                <input name="rep3" type="text" width="150"><input name="repCorrecte" type="radio" value="3">
                <br />
                <br />
                <label for="rep4">Réponse 4 :</label>
                <input name="rep4" type="text" width="150"><input name="repCorrecte" type="radio" value="4">
                <br />
                <br />
                <input type="submit" value="Ajouter">
            </form>
        </div>
        <div class="pied">
            <c:import url="_PIED.jsp"/>
        </div>
    </body>
</html>