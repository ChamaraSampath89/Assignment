package com.Chamara.Amazon;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.Chamara.Amazon.Utility.PropertyFileHandler;
import com.Chamara.Amazon.Utility.WebDriverHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/resources/features/"}
		,glue={"com.Chamara.Amazon.StepDefinition"}
		,plugin= {"pretty","html:target/cucumber-report/cucumber.html"}
		//,format= {"pretty","html:target/Reports", "json:target/cucumber-report-composite.json" }
		,tags =  "@Amazon_001" 
		)

public class AmazonRunner {
	@BeforeClass
	public static void setup() throws FileNotFoundException, IOException {
		PropertyFileHandler.getPropertyFileHandler();
		PropertyFileHandler.loadPropertyFile("src/resources/testdata/testdata.properties");
		WebDriverHelper.startUpWebDriver(PropertyFileHandler.readProperty("Browser"), PropertyFileHandler.readProperty("Path"));
	}
	
	@AfterClass
	public static void teardown() throws FileNotFoundException, IOException {
		WebDriverHelper.getWebDriver().quit();
	}
	
}
