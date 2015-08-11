/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ocsfinweb.dao;

import com.ocsfinweb.model.OCSFINWEBBean;
import com.agresso.services.queryengineservice.queryenginev201101.*;
import com.ocsfinweb.webservices.QueryEngine_WS;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAXWELLPAYNE
 */
public class OCSFINWEBDAO_QEWS {
    
    //String username="CGIARAD\\mirungu"; //the username that will be used to connect to the web service
    //String password = "Rhumba@2015e"; //password of the system account
    String client = "GG";
    //String staffTemplate = "StaffStatementQEWS";
    QueryEngine_WS queryengine_ws = new QueryEngine_WS();
    WSCredentials credentials;
    
    //initialising the credentials to access UBW via QEWS
    
    public WSCredentials credentials(String username, String password) throws Exception
    {
        try
        {
            credentials = new com.agresso.services.queryengineservice.queryenginev201101.WSCredentials();
            credentials.setUsername(username);
            credentials.setPassword(password);
            credentials.setClient(client);
        
        }
        
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return credentials;
    
    }
    //get templateId
    
    private long templateId(String templatename,String myusername,String mypassword) throws Exception
    {
        long template_id=0;
        
        try
        {
            template_id = queryengine_ws.getTemplateList(null, templatename, credentials(myusername,mypassword)).getTemplateHeaderList().getTemplateHeader().get(0).getTemplateId();
            
        }
        catch(Exception ex)
        {
            throw new Exception(ex);        
        } 
        
        return template_id;
            
    }
    
    //public String 
    
    public List mydetails(String myusername, String mypassword) throws Exception
    {
        List response = new ArrayList();
        
        
        long id = templateId("UsersQEWS",myusername,mypassword);
        
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials(myusername,mypassword));
               InputForTemplateResult input = new InputForTemplateResult();
               
               TemplateResultOptions options = queryengine_ws.getTemplateResultOptions(credentials(myusername,mypassword));
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               
               input.setSearchCriteriaPropertiesList(searchProp.getSearchCriteriaPropertiesList());
               TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template UsersQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
    
    
        
    
    }
    public List mystatement(String myusername, String mypassword)throws Exception
    {
        List response = new ArrayList();
        
        
        long id = templateId("StaffStatementQEWS",myusername,mypassword);
        
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials(myusername,mypassword));
               InputForTemplateResult input = new InputForTemplateResult();
               TemplateResultOptions options = queryengine_ws.getTemplateResultOptions(credentials(myusername,mypassword));
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               input.setSearchCriteriaPropertiesList(searchProp.getSearchCriteriaPropertiesList());
               TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template StaffStatementQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
    
    }
    
    public List getmainproj(String costc, String entity, String myusername, String mypassword)throws Exception
    {
        List response = new ArrayList();
        long id = templateId("MainProjects_FINWEBQEWS",myusername,mypassword);
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials);
               InputForTemplateResult input = new InputForTemplateResult();
               ArrayOfSearchCriteriaProperties arrayofsearchcriteriaproperties = new ArrayOfSearchCriteriaProperties();
               TemplateResultOptions options = new TemplateResultOptions();
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               //SearchCriteriaProperties scp = new SearchCriteriaProperties();
               //scp.setColumnName("Costc");
               //scp.setIsPrompt(true);
               //scp.setIsPrompt(true);
               //scp.setFromValue("1101");
               for(SearchCriteriaProperties scp : searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties())
               {
                   //String columnname = scp.getColumnName();
                   if(scp.getColumnName().equals("dim2"))
                   {
                       scp.setFromValue(costc);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   if(scp.getColumnName().equals("dim5"))
                   {
                       scp.setFromValue(entity);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   
                   
                   
                    
                   
                   
                   //arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   //response.add(columnname);
                   
                  
               }
               //response.add(searchProp.getSearchCriteriaPropertiesList().);
               //response.add(arrayofsearchcriteriaproperties.getSearchCriteriaProperties().get(0).getColumnName());
               input.setSearchCriteriaPropertiesList(arrayofsearchcriteriaproperties);
               
               
               TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template MainProjFINWEBQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        
        return response;
    
    }
    
    public List getchargecodes(String costc, String mainproj, String entity, String myusername, String mypassword) throws Exception
    {
        List response = new ArrayList();
        long id = templateId("ChargeCodes_FINWEBQEWS",myusername,mypassword);
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials);
               InputForTemplateResult input = new InputForTemplateResult();
               ArrayOfSearchCriteriaProperties arrayofsearchcriteriaproperties = new ArrayOfSearchCriteriaProperties();
               TemplateResultOptions options = new TemplateResultOptions();
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               //SearchCriteriaProperties scp = new SearchCriteriaProperties();
               //scp.setColumnName("Costc");
               //scp.setIsPrompt(true);
               //scp.setIsPrompt(true);
               //scp.setFromValue("1101");
               for(SearchCriteriaProperties scp : searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties())
               {
                   /*activate 1 check columnsString columnname = scp.getColumnName();*/
                   if(scp.getColumnName().equals("dim2"))
                   {
                       scp.setFromValue(costc);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   if(scp.getColumnName().equals("dim5"))
                   {
                       scp.setFromValue(entity);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   if(scp.getColumnName().equals("r0dim3"))
                   {
                       scp.setFromValue(mainproj);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   }
                   
                   
                    
                   
                   
                   //arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   /*activate 2response.add(columnname);*/
                   
                  
               }
               //response.add(searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties());
               //response.add(arrayofsearchcriteriaproperties.getSearchCriteriaProperties().get(0).getColumnName());
               input.setSearchCriteriaPropertiesList(arrayofsearchcriteriaproperties);
               
               
               /**/TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template MainProjFINWEBQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
    
    }
    
    public List getperaccountclass(String workorder, String entity, String myusername, String mypassword) throws Exception
    {
        List response = new ArrayList();
        long id = templateId("PerAccountClass_FINWEBQEWS",myusername,mypassword);
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials);
               InputForTemplateResult input = new InputForTemplateResult();
               ArrayOfSearchCriteriaProperties arrayofsearchcriteriaproperties = new ArrayOfSearchCriteriaProperties();
               TemplateResultOptions options = new TemplateResultOptions();
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               //SearchCriteriaProperties scp = new SearchCriteriaProperties();
               //scp.setColumnName("Costc");
               //scp.setIsPrompt(true);
               //scp.setIsPrompt(true);
               //scp.setFromValue("1101");
               for(SearchCriteriaProperties scp : searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties())
               {
                   /*activate 1 check columnsString columnname = scp.getColumnName();*/
                   /**/if(scp.getColumnName().equals("dim4"))
                   {
                       scp.setFromValue(workorder);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   if(scp.getColumnName().equals("dim5"))
                   {
                       scp.setFromValue(entity);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   }
                   
                   
                    
                   
                   
                   //arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   /*activate 2response.add(columnname);*/
                   
                  
               }
               //response.add(searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties());
               //response.add(arrayofsearchcriteriaproperties.getSearchCriteriaProperties().get(0).getColumnName());
               input.setSearchCriteriaPropertiesList(arrayofsearchcriteriaproperties);
               
               
               /**/TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template MainProjFINWEBQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
    
    }
    
    public List getperaccount(String accountclass, String workorder, String entity, String myusername, String mypassword) throws Exception
    {
        List response = new ArrayList();
        long id = templateId("PerAccount_FINWEBQEWS",myusername,mypassword);
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials);
               InputForTemplateResult input = new InputForTemplateResult();
               ArrayOfSearchCriteriaProperties arrayofsearchcriteriaproperties = new ArrayOfSearchCriteriaProperties();
               TemplateResultOptions options = new TemplateResultOptions();
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);              
               for(SearchCriteriaProperties scp : searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties())
               {
                   //activate 1 check columnsString columnname = scp.getColumnName();
                  
                   if(scp.getColumnName().equals("account_grp__1"))
                   {
                       scp.setFromValue(accountclass);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   }
                   if(scp.getColumnName().equals("dim4"))
                   {
                       scp.setFromValue(workorder);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   if(scp.getColumnName().equals("dim5"))
                   {
                       scp.setFromValue(entity);
                       arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   }
                   //arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   //activate 2response.add(columnname);
                   
                  
               }

               
               input.setSearchCriteriaPropertiesList(arrayofsearchcriteriaproperties);
               
               
               /**/TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template MainProjFINWEBQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
    
    }
    
    public List getmainproj_entity(String param, String myusername, String mypassword)throws Exception
    {
        List response = new ArrayList();
        long id = templateId("MainProjects_FINWEBQEWS",myusername,mypassword);
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials);
               InputForTemplateResult input = new InputForTemplateResult();
               ArrayOfSearchCriteriaProperties arrayofsearchcriteriaproperties = new ArrayOfSearchCriteriaProperties();
               TemplateResultOptions options = new TemplateResultOptions();
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               //SearchCriteriaProperties scp = new SearchCriteriaProperties();
               //scp.setColumnName("Costc");
               //scp.setIsPrompt(true);
               //scp.setIsPrompt(true);
               //scp.setFromValue("1101");
               for(SearchCriteriaProperties scp : searchProp.getSearchCriteriaPropertiesList().getSearchCriteriaProperties())
               {
                   //String columnname = scp.getColumnName();
                   if(scp.getColumnName().equals("dim5"))
                   {
                       scp.setFromValue(param);
                       //arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   
                   }
                   
                   
                   
                    
                   
                   
                   arrayofsearchcriteriaproperties.getSearchCriteriaProperties().add(scp);
                   //response.add(columnname);
                   
                  
               }
               //response.add(searchProp.getSearchCriteriaPropertiesList().);
               //response.add(arrayofsearchcriteriaproperties.getSearchCriteriaProperties().get(0).getColumnName());
               input.setSearchCriteriaPropertiesList(arrayofsearchcriteriaproperties);
               
               
               TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
               
               
               
           
           }
           else
           {
               throw new Exception("Cannot find browser template MainProjFINWEBQEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        
        return response;
    
    }
    
    public List budgetholders(String myusername, String mypassword) throws Exception
    {
        List response = new ArrayList();
        
        long id = templateId("MainProjects_FINWEBQEWS",myusername,mypassword);
        
        try
        {
           if(id>0)
           {
               SearchCriteria searchProp = queryengine_ws.getSearchCriteria(id, true, credentials(myusername,mypassword));
               InputForTemplateResult input = new InputForTemplateResult();
               TemplateResultOptions options = queryengine_ws.getTemplateResultOptions(credentials(myusername,mypassword));
               options.setRemoveHiddenColumns(true);
               input.setTemplateResultOptions(options);
               input.setTemplateId(id);
               input.setSearchCriteriaPropertiesList(searchProp.getSearchCriteriaPropertiesList());
               TemplateResultAsXML results = queryengine_ws.getTemplateResultAsXML(input, credentials(myusername,mypassword));
               
               OCSFINWEBBean ocsfinwebbean = new OCSFINWEBBean();
               
               ocsfinwebbean.setXmlData(results.getTemplateResult());
              
               response.add(ocsfinwebbean);
           }
           else
           {
               throw new Exception("Cannot find browser template BudgetHolders_QEWS");
           
           }
            
        
        }
        catch(Exception ex)
        {
            throw new Exception(ex);
        
        }
        
        return response;
                
    
    }
    
}
