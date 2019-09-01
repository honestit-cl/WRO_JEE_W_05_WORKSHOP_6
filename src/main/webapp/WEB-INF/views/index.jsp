<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Strona główha</title>
</head>
<body>
<h1>Hurrrrrrraaaaa! Witaj ${username}</h1>

<h2>Dodaj tweet</h2>
<form:form method="post" modelAttribute="tweetData" action="/addTweet">
    <p>
        <form:textarea path="content"></form:textarea>
    </p>
    <p>
        <input type="submit" value="Dodaj"/>
    </p>
</form:form>
<h2>Najnowsze tweety</h2>
<table>
    <tr>
        <th>Data</th>
        <th>Treść</th>
        <th>Użytkownik</th>
    </tr>
    <c:forEach items="${latestTweets}" var="tweet">
        <tr>
            <td>${tweet.created}</td>
            <td>${tweet.content}</td>
            <td>${tweet.ownerUsername}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
