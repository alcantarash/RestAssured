package com.Requests;

import com.Bases.RequestBase;
import io.restassured.http.Method;

public class ConsultaRestricaoRequest extends RequestBase {

    public ConsultaRestricaoRequest(String cpf){
        requestService = "/restricoes/"+cpf;
        method = Method.GET;
    }
}
