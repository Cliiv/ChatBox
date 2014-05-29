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
	
</script>
</head>
<body>
	<h1>Personne n°${personne.id}</h1>
	<div>
		<table>
			<thead>
				<tr>
					<td>Chat</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${chatsPersonne}" var="chat">
					<tr>
						<td><a href="chat?chatId=${chat.id}"> ${chat.name}</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>