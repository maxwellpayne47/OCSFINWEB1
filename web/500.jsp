<%-- 
    Document   : index
    Created on : 07-Jul-2015, 10:58:36
    Author     : MAXWELLPAYNE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finance Web | Home</title>
        <c:import url="/Pages/includes.html"></c:import>
    </head>
    <body>
       <div id="mainbody">
           <div id="titles">
               <c:import url="/Pages/links.html"></c:import> 
           </div>
           <div id="contentbody">
               <h1>Error Page</h1>
                <div id="image_holder_500"></div>
                <div id="errmsg_holder">
                    An error has occured. Contact Admin on 4700 or write to <a href="mailto:m.irungu@cgiar.org">Maxwell Irungu</a>
                <br>
                <span style="text-decoration:underline;">Specific (Techie) error is:</span>
                <br>
                ${pageContext.exception}
                </div>
           </div>
       
       </div>
    </body>
</html>
