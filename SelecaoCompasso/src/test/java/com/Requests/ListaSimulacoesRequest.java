package com.Requests;

import com.Bases.RequestBase;
import io.restassured.http.Method;

public class ListaSimulacoesRequest extends RequestBase {

    public ListaSimulacoesRequest(){
        requestService = "/simulacoes";
        method = Method.GET;
    }
}
