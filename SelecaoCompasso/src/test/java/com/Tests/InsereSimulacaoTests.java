package com.Tests;

import com.Bases.TestBase;
import com.Requests.InsereSimulacaoRequest;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsereSimulacaoTests extends TestBase {

    InsereSimulacaoRequest insereSimulacaoRequest;

    @Test
    public void insereComDadosValidos(){

        SoftAssert softAssert = new SoftAssert();

        //Entrada
        String nome = "Fulano de Tal";
        String cpf = "97093236021";
        String email = "email@email.com";
        int valor = 1200;
        int parcelas = 3;
        boolean seguro = true;
        int statusCodeEsperado = HttpStatus.SC_CREATED;//Status Code 201

        insereSimulacaoRequest = new InsereSimulacaoRequest();
        insereSimulacaoRequest.setJsonBody(nome, cpf, email, valor, parcelas, seguro);
        Response response = insereSimulacaoRequest.executeRequest();

        Pattern pattern = Pattern.compile("\\d+,");//Ajustar depois para o tamanho do id gerado
        Matcher matcher = pattern.matcher(response.body().jsonPath().get("id").toString());

        //VerificacaoResposta

        Assert.assertEquals(response.statusCode(), statusCodeEsperado, "Status code esperado");
        softAssert.assertTrue(matcher.find(),"Id Gerado");
        softAssert.assertEquals(response.body().jsonPath().get("nome").toString(), nome, "Validação Nome");
        softAssert.assertEquals(response.body().jsonPath().get("cpf").toString(), cpf, "Validação Cpf");
        softAssert.assertEquals(response.body().jsonPath().get("email").toString(), email, "Validação Email");
        softAssert.assertEquals(response.body().jsonPath().get("valor").toString(), Integer.toString(valor), "Validação Valor");
        softAssert.assertEquals(response.body().jsonPath().get("parcelas").toString(), Integer.toString(parcelas), "Validação Parcelas");
        softAssert.assertEquals(response.body().jsonPath().get("seguro").toString(), Boolean.toString(seguro), "Validação Seguro");
        softAssert.assertAll();
    }
}
