import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Take_SS {

	public void takeSS(WebDriver dr,String path) throws IOException {
		
		
		 TakesScreenshot Screenshot =((TakesScreenshot)dr);
		 
		 File sourcefile=Screenshot.getScreenshotAs(OutputType.FILE);
		 
		 File Taget=new File(path);
		 
		 FileUtils.copyFile(sourcefile, Taget);
		
		
	}
	
}
