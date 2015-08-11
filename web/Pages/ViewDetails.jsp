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
              //loadperaccount($("#workorder_span").text(),$("#entity_span").text()); 
              //alert($("#workorder_span").text()+" "+$("#entity_span").text());
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
            <td><a href="#" id="summary_links">View per Grant</a></td>
            <td><a href="#" id="summary_links">View per Natural Classification</a></td>            
          </tr>
        </table>
        <a id="username_span" href="#">Logged in as ${sessionScope.username}</a>
      </div>
      <div style="width:90%; position:relative; margin-left:auto; margin-right:auto;" class="panel panel-primary">      
          <div class="panel-heading"><span id="info-span">View the Budget and Expenditure Breakdown</span><br>Account Class - <span id="accountclass_span">${param.ac}</span> Work Order - <span id="workorder_span"> <c:out value="${param.wo}"></c:out></span> Entity - <span id="entity_span"><c:out value="${param.et}"></c:out></span> </div>
      <table class="table table-condensed table-bordered table-hover" id="finweb_htmltbl" border="0">
        <thead id="finweb-header_htmltbl">
          <tr>
            <td>Account</td>
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
