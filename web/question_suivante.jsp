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
                        <th>Questions</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            <form method="post">
                            <label for="titre">${question.titre}</label>
                            <br />
                            <br />
                            <label for="rep1">${question.rep1}</label><input name="reponse" type="radio" checked="checked" value="1">
                            <br />
                            <br />
                            <label for="rep2">${question.rep2}</label><input name="reponse" type="radio" value="2">
                            <br />
                            <br />
                            <label for="rep3">${question.rep3}</label><input name="reponse" type="radio" value="3">
                            <br />
                            <br />
                            <label for="rep4">${question.rep4}</label><input name="reponse" type="radio" value="4">
                            <br />
                            <br />
                            <input type="submit" value="Suivant">
                            </form>
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
