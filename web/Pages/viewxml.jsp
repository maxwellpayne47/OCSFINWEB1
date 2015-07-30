<%-- 
    Document   : viewresponse
    Created on : 16-Jul-2015, 09:19:52
    Author     : MAXWELLPAYNE
--%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>jsp</title>
    </head>
    <body>
        <c:forEach var="ss" items="${requestScope.mydetails}">
            <c:out value="${ss.xmlData}"></c:out>
        </c:forEach>
        
    </body>
</html>
