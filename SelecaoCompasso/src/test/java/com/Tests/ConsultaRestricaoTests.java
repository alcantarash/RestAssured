package com.Tests;

import com.Bases.TestBase;
import com.Requests.ConsultaRestricaoRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConsultaRestricaoTests extends TestBase {

    ConsultaRestricaoRequest consultaRestricaoRequest;

    @Test
    public void CpfComRestricao(){

        //Entrada
        String cpf = "97093236014";//Cpf como string?
        String msgEperada = "O CPF " +cpf+ " tem problema";//possui restrição
        int statusCodeEsperado = HttpStatus.SC_OK;//Status Code 200

        consultaRestricaoRequest = new ConsultaRestricaoRequest(cpf);
        Response response = consultaRestricaoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        Assert.assertEquals(response.body().jsonPath().get("mensagem").toString(), msgEperada, "Cpf com restrição!");
    }

    @Test
    public void StringSemRestricao(){

        //Entrada
        String cpf = "NaoSouCPF";//Cpf como string?
        int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;//Status Code 204
        //String msgEperada = "Não possui restrição";

        consultaRestricaoRequest = new ConsultaRestricaoRequest(cpf);
        Response response = consultaRestricaoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        //Assert.assertEquals(response.body().jsonPath().get("mensagem").toString(), msgEperada, "Cpf sem restrição!");

    }

    @Test
    public void CpfSemRestricao(){

        //Entrada
        String cpf = "00000000191";//Cpf como string?
        int statusCodeEsperado = HttpStatus.SC_NO_CONTENT;//Status Code 204
        //String msgEperada = "Não possui restrição";

        consultaRestricaoRequest = new ConsultaRestricaoRequest(cpf);
        Response response = consultaRestricaoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), statusCodeEsperado);
        //Assert.assertEquals(response.body().jsonPath().get("mensagem").toString(), msgEperada, "Cpf sem restrição!");

    }
}
