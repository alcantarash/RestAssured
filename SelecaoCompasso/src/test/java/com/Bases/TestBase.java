package com.Bases;

import com.GlobalThings;

import com.Helpers.ExtentReportHelpers;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public abstract class TestBase {

    @BeforeSuite
    public void beforSuite(){
        new GlobalThings();
        ExtentReportHelpers.createReport();
    }

    @BeforeMethod
    public void beforeTest(Method method){
        ExtentReportHelpers.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        ExtentReportHelpers.addTestResult(result);
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReportHelpers.generateReport();
    }

}
