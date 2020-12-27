package com.Tests;

import com.Bases.TestBase;
import com.Requests.AlteraSimulacaoRequest;
import com.Requests.InsereSimulacaoRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test
public class AlteraSimulacaoTests extends TestBase {

    AlteraSimulacaoRequest alteraSimulacaoRequest;

    public void AlterandoSimulacaoExistente(){

        SoftAssert softAssert = new SoftAssert();

        //Entrada
        String nome = "Fulano de Tal";
        String cpf = "66414919004";
        String email = "email@email.com";
        int valor = 1200;
        int parcelas = 3;
        boolean seguro = true;
        int statusCodeEsperado = HttpStatus.SC_OK;//Status Code 200

        alteraSimulacaoRequest = new AlteraSimulacaoRequest(cpf);
        alteraSimulacaoRequest.setJsonBody(nome, cpf, email, valor, parcelas, seguro);
        Response response = alteraSimulacaoRequest.executeRequest();

        Assert.assertEquals(response.statusCode(), statusCodeEsperado, "Status code esperado");
        softAssert.assertEquals(response.body().jsonPath().get("nome").toString(), nome, "Validação Nome");
        softAssert.assertEquals(response.body().jsonPath().get("cpf").toString(), cpf, "Validação Cpf");
        softAssert.assertEquals(response.body().jsonPath().get("email").toString(), email, "Validação Email");
        softAssert.assertEquals(response.body().jsonPath().get("valor").toString(), Integer.toString(valor), "Validação Valor");
        softAssert.assertEquals(response.body().jsonPath().get("parcelas").toString(), Integer.toString(parcelas), "Validação Parcelas");
        softAssert.assertEquals(response.body().jsonPath().get("seguro").toString(), Boolean.toString(seguro), "Validação Seguro");
        softAssert.assertAll();
    }
}
