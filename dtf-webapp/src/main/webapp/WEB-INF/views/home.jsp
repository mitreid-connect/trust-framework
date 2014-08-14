<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dynamic Trust Framework Webapp- Home</title>
</head>
<body>
	<div>
		<h2>Dynamic Trust Framework Webapp</h2>
		<p>
		The purpose of this webapp is to demonstrate a proof-of-concept of a process 
		to dynamically generate an identity trust framework based on a certain set of requirements.
		</p>
		<p>
		For more information: <a href="https://github.com/mitreid-connect/trust-framework">https://github.com/mitreid-connect/trust-framework</a>
		</p>
	</div>
	
	<div>
	<ol class="card-list">
		<c:forEach var="card" items="${cards}">
			<span class="cardData">
				<c:out value="${card.title}" />, id: <c:out value="${card.id}" /><br/>
				<c:out value="${card.description}" /><br/>
				Provides: <c:out value="${card.providesTags}" /><br/>
				Dependencies: <c:out value="${card.dependencies}" /><br/>
			</span>
			<br/>
		</c:forEach>
	</ol>
	
	</div>
</body>
</html>