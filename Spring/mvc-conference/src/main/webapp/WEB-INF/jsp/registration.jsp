<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>

<body>
	<h1>Register here</h1>
	<form:form modelAttribute="registration">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td>
					<spring:message code="name" />:
				</td>
				<td>
					<form:input path="name" />
				</td>
				<td>
					<form:errors path="name" cssClass="error"/>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<input type="submit" value="Add Registration" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>