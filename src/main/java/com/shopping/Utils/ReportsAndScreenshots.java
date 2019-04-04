package com.shopping.Utils;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportsAndScreenshots 
{

	public static void captureScreenShot(WebDriver ldriver){
		// Take screenshot and store as a file format             
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);           
		try {
			// now copy the  screenshot to desired location using copyFile method

			FileUtils.copyFile(src, new File("../sampleHackProj/ResultOutput/"+System.currentTimeMillis()+".png"));                              
			} 
		catch (IOException e)

		{
				System.out.println(e.getMessage()) ;
		}
	}
}
