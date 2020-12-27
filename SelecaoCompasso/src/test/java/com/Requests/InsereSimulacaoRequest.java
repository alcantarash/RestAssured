package com.Requests;

import com.Bases.RequestBase;
import com.Helpers.GeneralHelpers;
import io.restassured.http.Method;

public class InsereSimulacaoRequest extends RequestBase {

    public InsereSimulacaoRequest(){
        requestService = "/simulacoes";
        method = Method.POST;
    }

    public void setJsonBody(String nome, String cpf, String email,int valor, int parcelas, boolean seguro){

        jsonBody = GeneralHelpers.readFileToAString("src/test/java/com/Jsons/InsereSimulacaoJson.json");

        jsonBody = jsonBody.replace("$nome", nome);
        jsonBody = jsonBody.replace("$cpf", cpf);
        jsonBody = jsonBody.replace("$email", email);
        jsonBody = jsonBody.replace("$valor", Integer.toString(valor));
        jsonBody = jsonBody.replace("$parcelas", Integer.toString(parcelas));
        jsonBody = jsonBody.replace("$seguro", Boolean.toString(seguro));

    }


}
