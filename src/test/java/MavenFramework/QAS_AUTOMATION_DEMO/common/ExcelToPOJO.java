package MavenFramework.QAS_AUTOMATION_DEMO.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.poiji.bind.Poiji;

import model.sendEmail;

public class ExcelToPOJO {
	
	private static List<sendEmail> emailData = new ArrayList<sendEmail>();;
	
	public void getDatafromExcel() {
	
	emailData = Poiji.fromExcel(new File("/Users/neha/qas-workspace/QAS_AUTOMATION_DEMO/QASDemoDate.xlsx"), sendEmail.class);


	}
	
	@DataProvider(name = "testcase-provider")
	  public static Object[] testcaseProvider() {

	  Object[] theListofTests = emailData.toArray();

	  return theListofTests;

	  }
    
}
