<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="org.chatbox.business.Chat" %>
<%@ page import="org.chatbox.business.Message" %>
<%@ page import="org.chatbox.business.Personne" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${chat.id}
	<c:forEach items="${chat.messages}" var="msg">
		<p>${msg.personne.name} : ${msg.texte}</p><br />
	</c:forEach>
	<form:form modelAttribute="newMessage" action="message" method="post">
		<form:input path="texte" />
		<form:input path="personne.idPersonne" />
		<form:input path="chat.id" />
		<input type="submit" value="Envoyer la purée" />
	</form:form>
</body>
</html>