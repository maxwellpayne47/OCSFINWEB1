/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){

$('.redirect_home').click(function(){
	  alert
	  window.location.href = "/OCSFINWEB/Pages/Organogram.jsp";
	  
	  })
function validate_login()
 {
	 var validation=1;
	 var username = $("#username_textfield").val();
	 var password = $("#password_textfield").val();	
	 
	 if($.trim(username)=="")
	 {
		 $("#errmsg_username_span").html('Username required');
		 validation=0;		 
	 }
	 else
	 {
		 $("#errmsg_username_span").html('');
		 
	 }
	 if($.trim(password)=="")
	 {
		 $("#errmsg_password_span").html('Password required');
		 validation=0;		 
	 }
	 else
	 {
		 $("#errmsg_password_span").html('');
		 
	 }
	 
	 
	 if(validation==1)
	{
	 return true;	
	}
	if(validation==0)
	{
		return false;
	}
	  
 }
 $("#loginsubmit_form").submit(function(e){
	 if(validate_login()==false)
	 {
		 e.preventDefault();
	 }
	 else
	 {
		 
	 }
	 }) 
          
})


 function commaSeparateNumber(val){
    while (/(\d+)(\d{3})/.test(val.toString())){
      val = val.toString().replace(/(\d+)(\d{3})/, '$1'+','+'$2');
    }
    return val;
  }
 
 function format_number(tableid)
 {
     $(tableid).find(".format_number").each(function(){
         var num = parseFloat($(this).text()).toFixed(2);
         //alert(num)
         if(num<0)
         {
             $(this).css({"color":"red"});
         }
         
     })
     
     
 }
    
var img = '<img src="/OCSFINWEB/Images/sm_loader.gif" width="25" height="25">';   
function mydetails()
{
    $.post("/OCSFINWEB/MyStaffStatement.do",{"param":"mydetails"},function(data){
       var xmldata,xmlDOC;
      if(!$.isEmptyObject(data))
      {
          //alert("")
          var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");                  
            $(node1).each(function(){                               
                var staffaccount = $(this).find("dim_value").text();
                var staffname = $(node1).find("description").text();                
                $('#staffname_span').text(staffname);
                $('#staffaccount_span').text(staffaccount);                
            });  
      }
      else
      {
          alert("no data");
      }
    },'json');        
}    

function loadmystatement()
   {
       
        $('#staffstatement_htmltbl tr:not(:first)').remove();
	
	
	html = '<tr id=\"loaderrow\"><td colspan=\"8\" align=\"center\">'+img+'</td</tr>';
        $('#loadingmsg_span').text("Please wait while your details are loading...");
	$("#staffstatement_htmltbl").append(html).show();
       
      $.post("/OCSFINWEB/MyStaffStatement.do",{"param":"mystatement"},function(data){
          var xmldata,xmlDOC;
       
          
          if(!$.isEmptyObject(data))
          {
            //alert("data")
            var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");            
            var html='';
            $('#staffstatement_htmltbl tr:not(:first)').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
                var transaction = $(this).find("voucher_no").text();
                var reference = $(this).find("ext_inv_ref").text();
                var date = $.format.date($(this).find("due_date").text(),"dd-MMM-yyyy");
                var exp_type = $(this).find("xdim_6").text();
                var currency = $(this).find("pay_currency").text();
                var cur_amount = commaSeparateNumber(parseFloat($(this).find("f0_currency_amo").text()).toFixed(2));
                var usd_amount = commaSeparateNumber(parseFloat($(this).find("amount").text()).toFixed(2));
                var description = $(this).find("description").text();
                
                html+="<tr><td>"+transaction+"</td><td>"+reference+"</td><td>"+date+"</td><td>"+exp_type+"</td><td>"+currency+"</td><td><span class=\"curamount_span format_number\">"+cur_amount+"</span></td><td><span class=\"usdamt_span format_number\">"+usd_amount+"</span></td><td>"+description+"</td></tr>";
                
                
            });
            $("#loaderrow").remove(); 
            $("#staffstatement_htmltbl tbody").append(html).show();
            //$("#mystatement_htmltbl tbody tr:last").remove()
            var iou_amount = parseFloat($("#staffstatement_htmltbl tbody tr:last").find(".usdamt_span").text());            
            if(iou_amount<0)
            {
                $("#iou_msg_span").text("ICRAF owes you USD$:").css({"color":"green","font-size":"24px"}).end();
                $("#iou_amt_span").text(iou_amount*-1).css({"font-size":"24px","text-decoration":"underline"});
            }
            else
            {
                $("#iou_msg_span").text("You owe ICRAF USD$:").css({"color":"red","font-size":"24px"});
                $("#iou_amt_span").text(iou_amount).css({"font-size":"24px","text-decoration":"underline"});
                
            }
            //$("#staffstatement_htmltbl tfoot").remove();
            $("#staffstatement_htmltbl tbody tr:last").clone().appendTo("#staffstatement_htmltbl tfoot");            
            $("#staffstatement_htmltbl tbody tr:last").remove(); 
            $("#staffstatement_htmltbl tfoot").find(".curamount_span").text("");
            
            
            
            
            //var title = $xml.find("account");
            //$("#desc_span").text(title.text());
           
              
          }
          else
          {
              alert("empty");
          }
          format_number("#staffstatement_htmltbl");
          
      },'json') 
   }
   function loadmainprojects(costc,entity)
   {
       
       $("#finweb_htmltbl tbody tr").remove();
       html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
       $("#finweb_htmltbl").append(html).show();
       $.post("/OCSFINWEB/FinanceWeb.do",{cc:costc,en:entity,mode:"bh"},function(data){
           var xmldata,xmlDOC;
       
          
          if(!$.isEmptyObject(data))
          {
            //alert(data);
            var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");            
            var html='';
            $('#finweb_htmltbl tbody tr').remove();
            $(node1).each(function(){
                
                
                var mainproj = $(this).find("r0dim3").text();
                var budget = parseFloat($(this).find("pld_amount").text()).toFixed(0);
                var actuals = parseFloat($(this).find("amount").text()).toFixed(0);                
                var commitment = parseFloat($(this).find("co_rest_amount").text()).toFixed(0);
                var totalexp = parseFloat(actuals)+parseFloat(commitment);
                var available = parseFloat(budget)-parseFloat(totalexp);
                var utilized;
                if(isFinite(parseFloat((totalexp/budget)*100).toFixed(0))===true)
                {
                     utilized = parseFloat((totalexp/budget)*100).toFixed(0)
                }
                else
                {
                     utilized = 100;
                    
                }
                
                html+="<tr><td><a class=\"drilldown_link\" href=\"/OCSFINWEB/Pages/CostCentre.jsp?cc="+costc+"&mj="+mainproj+"&en="+entity+"\">"+mainproj+"<a/></td><td><span class=\"format_number\">"+commaSeparateNumber(budget)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(actuals)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(commitment)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(totalexp)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(available)+"</span></td><td>"+utilized+"</td></tr>";
                
            })
                
                $("#loaderrow").remove(); 
                $("#finweb_htmltbl").append(html).show();
                $("#finweb_htmltbl tfoot tr").remove();
                $("#finweb_htmltbl tbody tr:last").clone().appendTo("#finweb_htmltbl tfoot");
                $("#finweb_htmltbl tbody tr:last").remove();
                 
                
                
           } 
           else
           {
               alert("We got nothing")
           }
           format_number("#finweb_htmltbl");
       },'json')
   }
   
   function loadchargecodes(costc,mainproj,entity)
   {
       
       $("#finweb_htmltbl tbody tr").remove();
       html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
       $("#finweb_htmltbl").append(html).show();
       $.post("/OCSFINWEB/FinanceWeb.do",{costc:costc,mainproj:mainproj,entity:entity,mode:"cc"},function(data){
           var xmldata,xmlDOC;
       
          
          if(!$.isEmptyObject(data))
          {
            //alert(data);
            var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");            
            var html='';
            $('#finweb_htmltbl tbody tr').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
                var utilized;
                var dim2 = $(this).find("dim2").text();
                var dim3 = $(this).find("dim3").text();
                var dim4= $(this).find("dim4").text();
                var dim5 = $(this).find("dim5").text();
                var chargecodes = dim2.concat("-",dim3.concat("-",dim4.concat("-",dim5)));
                var budget = parseFloat($(this).find("pld_amount").text()).toFixed(0);
                var actuals = parseFloat($(this).find("amount").text()).toFixed(0);                
                var commitment = parseFloat($(this).find("co_rest_amount").text()).toFixed(0);
                var totalexp = parseFloat(actuals)+parseFloat(commitment);
                var available = budget-totalexp;
                if(isFinite(parseFloat((totalexp/budget)*100).toFixed(0))===true)
                {
                     utilized = parseFloat((totalexp/budget)*100).toFixed(0)
                }
                else
                {
                     utilized = 100;
                    
                }
                
                
                html+="<tr><td><a class=\"drilldown_link\" href=\"/OCSFINWEB/Pages/NaturalClassification.jsp?wo="+dim4+"&et="+dim5+"\">"+chargecodes+"<a/></td><td><span class=\"format_number\">"+commaSeparateNumber(budget)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(actuals)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(commitment)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(totalexp)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(available)+"</span></td><td>"+utilized+"</td></tr>";
                
            })
                
                $("#loaderrow").remove(); 
                $("#finweb_htmltbl").append(html).show();
                $("#finweb_htmltbl tfoot tr").remove();
                $("#finweb_htmltbl tbody tr:last").clone().appendTo("#finweb_htmltbl tfoot");
                $("#finweb_htmltbl tbody tr:last").remove();
                 
                
                
           } 
           else
           {
               alert("We got nothing");
           }
           format_number("#finweb_htmltbl");
       },'json');
       
       
   }
   
   function loadperaccountclass(workorder,entity)
   {
       
       $("#finweb_htmltbl tbody tr").remove();
       html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
       $("#finweb_htmltbl").append(html).show();
       $.post("/OCSFINWEB/FinanceWeb.do",{workorder:workorder,entity:entity,mode:"nc"},function(data){
           var xmldata,xmlDOC;
       
          
          if(!$.isEmptyObject(data))
          {
            //alert(data);
            var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");            
            var html='';
            $('#finweb_htmltbl tbody tr').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
               
                var accountclass = $(this).find("account_grp__1").text();;
                var budget = parseFloat($(this).find("pld_amount").text()).toFixed(0);
                var actuals = parseFloat($(this).find("amount").text()).toFixed(0);                
                var commitment = parseFloat($(this).find("co_rest_amount").text()).toFixed(0);
                var totalexp = parseFloat(actuals)+parseFloat(commitment);
                var available = budget-totalexp;
                var utilized;
                if(isFinite(parseFloat((totalexp/budget)*100).toFixed(0))===true)
                {
                     utilized = parseFloat((totalexp/budget)*100).toFixed(0)
                }
                else
                {
                     utilized = 100;
                    
                }
                
                html+="<tr><td><a class=\"drilldown_link\" href=\"/OCSFINWEB/Pages/AccountClass.jsp?ac="+accountclass+"&wo="+workorder+"&et="+entity+"\">"+accountclass+"<a/></td><td><span class=\"format_number\">"+commaSeparateNumber(budget)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(actuals)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(commitment)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(totalexp)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(available)+"</span></td><td>"+utilized+"</td></tr>";
                
            })
                
                $("#loaderrow").remove(); 
                $("#finweb_htmltbl").append(html).show();
                $("#finweb_htmltbl tfoot tr").remove();
                $("#finweb_htmltbl tbody tr:last").clone().appendTo("#finweb_htmltbl tfoot");
                $("#finweb_htmltbl tbody tr:last").remove();
                 
                
                
           } 
           else
           {
               alert("We got nothing");
           }
           format_number("#finweb_htmltbl");
       },'json');
       
       
   }
   function loadperaccount(accountclass,workorder,entity)
   {
       
       $("#finweb_htmltbl tbody tr").remove();
       html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
       $("#finweb_htmltbl").append(html).show();
       $.post("/OCSFINWEB/FinanceWeb.do",{accountclass:accountclass,workorder:workorder,entity:entity,mode:"ac"},function(data){
           var xmldata,xmlDOC;
       
          
          if(!$.isEmptyObject(data))
          {
            //alert(data);
            var len = data.length;
            for (var i = 0; i< len; i++)
                {
                    xmldata = [data[i].xmlData];
                }
            //$("#desc_span").text(xmldata);
            //parse the xml
           // alert(xmldata)
            var xml = xmldata.toString();
            xmlDOC = $.parseXML(xml);
            $xml = $(xmlDOC);
            //alert($xml)
            var node1 = $xml.find("AgressoQE");            
            var html='';
            $('#finweb_htmltbl tbody tr').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
               
                var account = $(this).find("dim1").text();;
                var budget = parseFloat($(this).find("pld_amount").text()).toFixed(0);
                var actuals = parseFloat($(this).find("amount").text()).toFixed(0);                
                var commitment = parseFloat($(this).find("co_rest_amount").text()).toFixed(0).toLocaleString("en");
                var totalexp = parseFloat(actuals)+parseFloat(commitment);
                var available = budget-totalexp;
                var utilized;
                if(isFinite(parseFloat((totalexp/budget)*100).toFixed(0))===true)
                {
                     utilized = parseFloat((totalexp/budget)*100).toFixed(0)
                }
                else
                {
                     utilized = 100;
                    
                }
                
                html+="<tr><td><a class=\"drilldown_link\" href=\"/OCSFINWEB/Pages/ViewDetails.jsp?ac="+account+"&wo="+workorder+"&et="+entity+"\">"+account+"<a/></td><td><span class=\"format_number\">"+commaSeparateNumber(budget)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(actuals)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(commitment)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(totalexp)+"</span></td><td><span class=\"format_number\">"+commaSeparateNumber(available)+"</span></td><td>"+utilized+"</td></tr>";
                
            })
                
                $("#loaderrow").remove(); 
                $("#finweb_htmltbl").append(html).show();
                $("#finweb_htmltbl tfoot tr").remove();
                $("#finweb_htmltbl tbody tr:last").clone().appendTo("#finweb_htmltbl tfoot");
                $("#finweb_htmltbl tbody tr:last").remove();
                 
                
                
           } 
           else
           {
               alert("We got nothing");
           }
           format_number("#finweb_htmltbl");
       },'json');
       
       
   }
   
   
//});

