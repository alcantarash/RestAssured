package com.Bases;

import com.GlobalThings;
import static io.restassured.RestAssured.*;//Para a variável config no construtor
import com.Helpers.ExtentReportHelpers;
import com.Helpers.RestAssuredHelpers;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;

public abstract class RequestBase {

    protected String url = GlobalThings.URL;
    protected String requestService = null;
    protected Method method = null;
    protected String jsonBody = null;
    protected Map<String, String> headers = new HashMap<String, String>();
    protected Map<String, String> cookies = new HashMap<String, String>();
    protected Map<String, String> queryParameters = new HashMap<String, String>();

    public RequestBase(){
        config = RestAssuredConfig.newConfig().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL));
        enableLoggingOfRequestAndResponseIfValidationFails();
        headers.put("accept", "*/*");
    }

    public Response executeRequest() {
        Response response = RestAssuredHelpers.executeRequest(url, requestService, method, headers, cookies, queryParameters, jsonBody);
        ExtentReportHelpers.addTestInfo(url, requestService, method.toString(), headers, cookies, queryParameters, jsonBody, response);

        return response;
    }

    public void removeHeader(String header){
        headers.remove(header);
    }

    public void removeCookie(String cookie){
        cookies.remove(cookie);
    }

    public void setMehtod(Method method){
        this.method = method;
    }

}
