<%-- 
    Document   : index
    Created on : 07-Jul-2015, 10:58:36
    Author     : MAXWELLPAYNE
--%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Finance Web | Staff Statement</title>
        <c:import url="includes.html"></c:import>         
        <script type="text/javascript">
            $(document).ready(function(){
                mydetails();
                loadmystatement();
            })
               
        </script>
    </head>
    <body>
        
       <div id="mainbody">
           <div id="titles">
               <c:import url="/Pages/links.html"></c:import> 
           </div>
       <div id="contentbody">
           
           <div id="staffdetails_div" class="panel panel-default">
                <div class="panel-heading">
                  <h3 class="panel-title">Staff Details</h3>
                </div>
                <div class="panel-body">                  
                    <table width="100%" class="table" border="0">
                      <tr>
                        <td><span class="boldtexts">Staff Name: </span><span id="staffname_span" class="lessboldtexts"></span></td>
                        <td colspan="2"><span class="boldtexts">Account Number: </span><span id="staffaccount_span"  class="lessboldtexts"></span></td>
                      </tr>
                      <tr>
                          <td colspan="3"><span id="iou_msg_span"></span> <span id="iou_amt_span"></span></td>
                      </tr>
                    </table>
                </div>
                </div>
           <div id="staffstatement_div" class="panel panel-primary">
            <div class="panel-heading">
                <h5 class="panel-title">My Staff Statement Details</h5>
            </div>
            <div class="panel-body">                     
                <table width="100%" align="center" class="table table-bordered table-hover" border="0" id="mystatement_htmltbl">
                    <thead>
                        <tr>
                          <td>Transaction No.</td>
                          <td>Invoice No.</td>
                          <td>Date</td>
                          <td>Currency</td>
                          <td>Amount</td>
                          <td>USD Amount</td>
                          <td>Description</td>
                        </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td><span id="desc_span"></span></td>
                  </tr>
                  </tbody>
                </table>
                </div>
        </div>

           
       </div>
       
       </div>
    </body>
</html>
