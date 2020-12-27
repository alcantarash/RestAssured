package com.Tests;

import com.Bases.TestBase;
import com.Requests.ListaSimulacoesRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListaSimulacoesTests extends TestBase {

    @Test
    public void retornaSimulacoes() {
        int statusCodeEsperado = HttpStatus.SC_OK;//Status Code 200

        ListaSimulacoesRequest listaSimulacoesRequest = new ListaSimulacoesRequest();
        Response response = listaSimulacoesRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), statusCodeEsperado, "Status code esperado");
        //Assert.assertEquals(response.body().jsonPath().get("id").);
    }
}
