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
        <title>Finance Web | Login</title>
        <c:import url="/Pages/includes.html"></c:import>
    </head>
    <body>
       <div id="mainbody">
           <div id="titles">
               <c:import url="/Pages/links.html"></c:import> 
           </div>
           <div id="contentbody">
               <div id="login_div">
                   <div class="alert alert-info" style="text-align:center;">
      <span style="color: green;">${param.infmsg}</span>
      <span style="color: red;">${param.errmsg}</span>
  </div>
 <div style="width:50%; position:relative; margin-left:auto; margin-right:auto;" class="panel panel-primary">
 <div class="panel-heading">Please enter your login credentials</div>
 <form method="post" autocomplete="off" id="loginsubmit_form" action="/OCSFINWEB/Login.do">
      <table class="table table-condensed" style="table-layout:fixed;" border="0">        
          <tr>
          <td>Username</td>
          <td><label for="username_textfield"></label>
              <input type="text" name="username_textfield" id="username_textfield"></td>
          <td><span style="color: red;"  id="errmsg_username_span"></span></td>          
          </tr>
        <tr>
          <td>Password</td>
          <td><label for="password_textfield"></label>
              <input type="password" name="password_textfield" id="password_textfield"></td>
          <td><span style="color: red" id="errmsg_password_span"></span></td>
        </tr>
        <tr>
          <td colspan="3" align="center"><input type="submit" name="login_button" id="login_button" value="Login"></td>
          </tr>              
      </table>
      </form>
      </div>  
                   
               </div>
               
          
           </div>
       
       </div>
    </body>
</html>
