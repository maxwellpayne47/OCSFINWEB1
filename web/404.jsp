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
               <h1>Page not found</h1>
                <div id="image_holder_404"></div>
                <div id="errmsg_holder">
                The page requested does not exist. 
                <br>

                </div>
           </div>
       
       </div>
    </body>
</html>
