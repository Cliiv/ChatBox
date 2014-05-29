<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="org.chatbox.business.Chat"%>
<%@ page import="org.chatbox.business.Message"%>
<%@ page import="org.chatbox.business.Personne"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../vendor/jquery.js"></script>
<script type="text/javascript">
	function envoyerMessage() {
		var messageInfo = {
			"texte": $('#texte').val(),
			"personne.id": $('#idPersonne').val(),
			"chat.id": $('#chatId').val()
		};

		$.ajax({
			type : "POST",
			url : "message",
			data : messageInfo,
			success : function() {
				alert("Messgae envoyé");
			}
		});
	}
</script>
</head>
<body>
	<h1>Chat n°${chat.id}</h1>
	<div>
		<div style="float:left">
			<form:form modelAttribute="newMessage" method="post">
				<form:input path="texte" />
				<input type="hidden" name="idPersonne" id="idPersonne" value="${personne.id}" />
				<input type="hidden" name="chatId" id="chatId" value="${chat.id}"/>
			</form:form>
			<a href="#" onClick="envoyerMessage();">Envoyer le message</a>
		</div>
		<div>
			<table>
				<thead>
					<tr>
						<td>Personne</td>
						<td>Message</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${chat.messages}" var="msg">
						<tr>
							<td>${msg.personne.name}</td>
							<td>${msg.texte}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>