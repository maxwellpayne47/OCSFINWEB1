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
@WebService(serviceName = "RateV201010", portName = "RateV201010Soap", endpointInterface = "com.agresso.services.rateservice.ratev201010.RateV201010Soap", targetNamespace = "http://services.agresso.com/RateService/RateV201010", wsdlLocation = "WEB-INF/wsdl/Rate_WS/icraf.ocs.cgiar.org/Agressowshost/service.svc.rateservice/ratev201010.wsdl")
public class Rate_WS {

    public com.agresso.services.rateservice.ratev201010.ArrayOfRateUnitType getRates(com.agresso.services.rateservice.ratev201010.RateUnitType filter, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse createRate(com.agresso.services.rateservice.ratev201010.RateUnitType rate, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse createRates(com.agresso.services.rateservice.ratev201010.ArrayOfRateUnitType rates, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse updateRate(com.agresso.services.rateservice.ratev201010.RateUnitType rate, com.agresso.services.rateservice.ratev201010.ColumnsCode column, java.lang.String newValue, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse updateRates(com.agresso.services.rateservice.ratev201010.ArrayOfRateUnitType rates, com.agresso.services.rateservice.ratev201010.ColumnsCode column, java.lang.String newValue, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse updateRateByDateAndHistory(com.agresso.services.rateservice.ratev201010.RateUnitType rate, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.agresso.services.rateservice.ratev201010.RateResponse updateRatesByDateAndHistory(com.agresso.services.rateservice.ratev201010.ArrayOfRateUnitType rates, boolean includeDataInResponse, com.agresso.services.rateservice.ratev201010.WSCredentials credentials) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String about() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
