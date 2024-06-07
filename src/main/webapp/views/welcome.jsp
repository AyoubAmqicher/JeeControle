<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://xmlns.jcp.org/jsf/facelets" prefix="ui" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="<c:url value='/webjars/bootstrap/5.3.3/css/bootstrap.min.css' />" />
    <script src="<c:url value='/webjars/bootstrap/5.3.3/js/bootstrap.bundle.min.js' />"></script>
    <link rel="stylesheet" href="<c:url value='/css/styles.css' />" />
</head>
<body>
<h1>Welcome to the Employee Management System</h1>
<ul>
    <li><a href="<c:url value='/employeeList.jsp' />">Employees</a></li>
    <li><a href="<c:url value='/affectation.jsp' />">Assign</a></li>
</ul>
</body>
</html>
