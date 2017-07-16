<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register yourself</title>
</head>
<body>
	<sf:form method="POST" commandName="user">
	<sf:errors path="*" element="div" cssClass="errors" />
<sf:label path="firstName"
cssErrorClass="error">First Name</sf:label>: <sf:input path="firstName" cssErrorClass="error"/>
		<br />
<sf:label path="lastName"
cssErrorClass="error">Last Name</sf:label>: <sf:input path="lastName" cssErrorClass="error"/>
		<br />
<sf:label path="email"
cssErrorClass="error">Email</sf:label>: <sf:input path="email" cssErrorClass="error"/>
		<br />
<sf:label path="userName"
cssErrorClass="error">Username</sf:label>: <sf:input path="userName" cssErrorClass="error"/>
		<br />
<sf:label path="password"
cssErrorClass="error">Password</sf:label>: <sf:password path="password" cssErrorClass="error"/>
		<br />
		<input type="submit" value="Register" />
	</sf:form>
</body>
</html>