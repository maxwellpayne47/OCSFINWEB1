/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ocsfinweb.webservices;

import javax.jws.WebService;

/**
 *
 * @author MAXWELLPAYNE
 */
@WebService(serviceName = "QueryEngineV201101", portName = "QueryEngineV201101Soap", endpointInterface = "com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap", targetNamespace = "http://services.agresso.com/QueryEngineService/QueryEngineV201101", wsdlLocation = "WEB-INF/wsdl/QueryEngine_WS/icraf.ocs.cgiar.org/Agressowshost/service.svc.queryengineservice/queryenginev201101.wsdl")
public class QueryEngine_WS {
    
    private java.net.URL getProductionURL() throws Exception 
    {
        try 
        {
            return new java.net.URL("https://icraf.ocs.cgiar.org/Agressowshost/service.svc?QueryEngineService/QueryEngineV201101");
        }
        catch (Exception ex)
        {
         throw new Exception(ex);
        }
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateProperties getTemplateProperties(long templateId, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        try 
        {
            if(0==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateProperties(templateId, credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateProperties(templateId, credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateResultAsDataSet getTemplateResultAsDataSet(com.agresso.services.queryengineservice.queryenginev201101.InputForTemplateResult input, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        
         try 
        {
            if(1==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultAsDataSet(input, credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultAsDataSet(input, credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        /*com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
        com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
        return port.getTemplateResultAsDataSet(input, credentials);*/
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateResultOptions getTemplateResultOptions(com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        try 
        {
            if(1==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultOptions(credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultOptions(credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        /*com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
        com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
        return port.getTemplateResultOptions(credentials);*/
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateResultAsXML getTemplateResultAsXML(com.agresso.services.queryengineservice.queryenginev201101.InputForTemplateResult input, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        try 
        {
            if(1==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultAsXML(input, credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateResultAsXML(input, credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        /*com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
        com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
        return port.getTemplateResultAsXML(input, credentials);*/
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.SearchCriteria getSearchCriteria(long templateId, boolean hideUnused, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        try 
        {
            if(1==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getSearchCriteria(templateId, hideUnused, credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getSearchCriteria(templateId, hideUnused, credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        /*com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
        com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
        return port.getSearchCriteria(templateId, hideUnused, credentials);*/
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.Expression getExpression(long templateId, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.StatisticalFormula getStatisticalFormula(long templateId, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.FormatInfo getFormatInfo(long templateId, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateList getTemplateList(java.lang.String formList, java.lang.String descrList, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
         try 
        {
            if(1==0)
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateList(formList, descrList, credentials);

            }
            else
            {
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101((getProductionURL()), new javax.xml.namespace.QName("http://services.agresso.com/QueryEngineService/QueryEngineV201101","QueryEngineV201101"));
                com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
                return port.getTemplateList(formList, descrList, credentials);

            }
        }
        catch(Exception ex)
        {
            throw new UnsupportedOperationException(ex);
        
        }
        /*com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101 service = new com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101();
        com.agresso.services.queryengineservice.queryenginev201101.QueryEngineV201101Soap port = service.getQueryEngineV201101Soap();
        return port.getTemplateList(formList, descrList, credentials);*/
        //throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.queryengineservice.queryenginev201101.TemplateMetaData getTemplateMetaData(long templateId, com.agresso.services.queryengineservice.queryenginev201101.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String about() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
