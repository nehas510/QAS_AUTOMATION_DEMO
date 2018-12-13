package MavenFramework.QAS_AUTOMATION_DEMO;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MavenFramework.QAS_AUTOMATION_DEMO.common.ApachePOIExcelRead;
import MavenFramework.QAS_AUTOMATION_DEMO.common.ExcelToPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.sendEmail;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.ArrayList;



public class GmailTest {
	
	ExcelToPOJO dataExt = new ExcelToPOJO();
	
	public String encode(String raw) {
	    return Base64.getUrlEncoder()
	            .withoutPadding()
	            .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
	}

	@BeforeTest
	public void doBeforeMethod() {
		dataExt.getDatafromExcel();
		System.out.println("I am in before method");
		
	}
		
	
@Test(dataProvider = "testcase-provider", dataProviderClass = ExcelToPOJO.class)
public void sendEmailToMe(sendEmail data){
	
	//String emailBody = getEmailBody();
	
	String emailBody = encode("From:"+ data.getFromEmailID() +"\n" + 
			"To:" + data.getToEmailID() +"\n" + 
			"Subject:" + data.getSubject() +"\n" + 
			"Date:" + data.getDate() + "\n" + 
			"Message-ID:"+data.getMessageID()+"\n" + 
			"\n" + 
			""+data.getBody() +"");
	
	String accessToken = "ya29.GlxxBtixjbErQgnZj4sAR7sUBIsoMm2MNMazMUCkbF7tAdFTCKedPFfGgURICu98BXnTeT2Dpcg6mfysSpYmhtkZSZcTCf_uENlYE3CGnDpgtwjsR1w2KGUWI9nctg";
	RestAssured.baseURI = "https://www.googleapis.com";
	Response resp=given().auth().oauth2(accessToken)
			  .header("Content-Type", "application/json")
			  .body("{\n    \"raw\": \"" + emailBody + "\"\n    \n}")
			  .post("/gmail/v1/users/me/messages/send").then().assertThat().statusCode(200).
				extract().response();
	
	System.out.println(resp.asString());

}



}
