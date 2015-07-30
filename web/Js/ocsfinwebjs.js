/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//$(document).ready(function(){
    
var img = '<img src="/OCSFINWEB/Images/299.GIF" width="200" height="23">';   
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
       
        $('#mystatement_htmltbl tr:not(:first)').remove();
	
	
	html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
        $('#loadingmsg_span').text("Please wait while your details are loading...");
	$("#mystatement_htmltbl").append(html).show();
       
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
            $('#mystatement_htmltbl tr:not(:first)').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
                var transaction = $(this).find("voucher_no").text();
                var reference = $(this).find("ext_inv_ref").text();
                var date = $(this).find("due_date").text();
                var exp_type = $(this).find("xdim_6").text();
                var currency = $(this).find("pay_currency").text();
                var cur_amount = parseFloat($(this).find("cur_amount").text()).toFixed(2);
                var usd_amount = parseFloat($(this).find("amount").text()).toFixed(2);
                var description = $(this).find("description").text();
                
                html+="<tr><td>"+transaction+"</td><td>"+reference+"</td><td>"+date+"</td><td>"+currency+"</td><td>"+cur_amount+"</td><td><span class=\"usdamt_span\">"+usd_amount+"</span></td><td>"+description+"</td></tr>";
                
                
            });
            $("#loaderrow").remove(); 
            $("#mystatement_htmltbl").append(html).show();
            //$("#mystatement_htmltbl tbody tr:last").remove()
            var iou_amount = parseFloat($("#mystatement_htmltbl tbody tr:last").find(".usdamt_span").text());
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
            
            
            //var title = $xml.find("account");
            //$("#desc_span").text(title.text());
           
              
          }
          else
          {
              alert("empty");
          }
          
      },'json') 
   }
   function loadmainprojects(mainproj)
   {
       $("#finweb_htmltbl tbody tr").remove();
       html = '<tr id=\"loaderrow\"><td colspan=\"7\" align=\"center\">'+img+'</td</tr>';
       $("#finweb_htmltbl").append(html).show();
       $.post("/OCSFINWEB/FinanceWeb.do",{"param":mainproj},function(data){
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
            $('#finweb_htmltbl tbody tr').remove();
            $(node1).each(function(){
                
                //var account = $xml.find("account")
                var mainproj = $(this).find("r0dim3").text();
                var budget = parseFloat($(this).find("pld_amount").text()).toFixed(0);
                var actuals = parseFloat($(this).find("amount").text()).toFixed(0);                
                var commitment = parseFloat($(this).find("co_rest_amount").text()).toFixed(0);
                var totalexp = parseFloat($(this).find("f0_totalexp5").text()).toFixed(0);
                var available = parseFloat($(this).find("f1_available6").text()).toFixed(0);
                var utilized = parseFloat($(this).find("f2_utilized7").text());
                
                html+="<tr><td>"+mainproj+"</td><td>"+budget+"</td><td>"+actuals+"</td><td>"+commitment+"</td><td>"+totalexp+"</td><td>"+available+"</td><td>"+utilized+"</td></tr>";
                
            })
                
                $("#loaderrow").remove(); 
                $("#finweb_htmltbl").append(html).show();
                $("#finweb_htmltbl tfoot tr").remove();
                $("#finweb_htmltbl tbody tr:last").clone().appendTo("#finweb_htmltbl tfoot");
                 
                
                
           }   
       },'json')
   }
//});

