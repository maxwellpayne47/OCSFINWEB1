<%-- 
    Document   : BudgetHolder
    Created on : May 30, 2014, 11:04:04 AM
    Author     : Maxwell Irungu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="includes.html"></c:import>  
        <title>Finance Web | Financial Statements</title>
        <script>
            
            $(document).ready(function(){
              loadchargecodes($("#costc_span").text(),$("#mainproj_span").text(),$("#entity_span").text()); 
              //alert($("#costc_span").text()+" "+$("#mainproj_span").text());
            })
        </script>
    </head>
    <body>
        <input type="hidden" id="">
    <div id="mainbody">
           <div id="titles">
               <c:import url="/Pages/links.html"></c:import> 
           </div>
           <div id="contentbody">
               
               <div id="finwebdetails_div">
      <div class="alert alert-info" style="text-align:center;">
      <span id="summary-info">Summary of Actual Expenditure v/s Operating Budget</span>
      <br>      
      <table width="60%" align="center" border="0">
          <tr>
            <td><a href="#" class="redirect_home" id="summary_links">View Organogram</a></td>
            <td><a href="/ICRAFFINWEB/ICRAFFINWEB.do?mode=pgbh&t1=${param.costc}" id="summary_links">View per Grant</a></td>
            <td><a href="#" id="summary_links">View per Natural Classification</a></td>            
          </tr>
        </table>
        <a id="username_span" href="#">Logged in as ${sessionScope.username}</a>
      </div>
      <div style="width:90%; position:relative; margin-left:auto; margin-right:auto;" class="panel panel-primary">      
          <div class="panel-heading"><span id="info-span">View the Budget and Expenditure Breakdown</span><br>Budget Holder ID:<span id="costc_span"> <c:out value="${param.cc}"></c:out></span> Main Project - <span id="mainproj_span"><c:out value="${param.mj}"></c:out></span> Entity : <span id="entity_span"><c:out value="${param.en}"></c:out></span> </div>
      <table class="table table-condensed table-bordered table-hover" id="finweb_htmltbl" border="0">
        <thead id="finweb-header_htmltbl">
          <tr>
            <td>Charge Code</td>
            <td>Budget</td>
            <td>Actuals</td>
            <td>Commitments</td>
            <td>Total Expenditure</td>
            <td>Available</td>
            <td>% Utilized</td>
          </tr>
          </thead>
          <tbody align="center">
          <tr>
             
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              <td></td>
              
          </tr>
          </tbody>
          <tfoot id="finweb-footer_htmltbl">
              
                  
              
          <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
                       
          </tr>
         
          </tfoot>
        </table>
        </div>
        </div>
      </div>
      <br> 
 </div>
 <br>
    </body>
</html>
