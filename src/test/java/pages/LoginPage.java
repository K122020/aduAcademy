package pages;

import org.openqa.selenium.By;

import base.CommonLibs;
import generics.Constants;

public class LoginPage extends CommonLibs {
	
	public void Lms_Login() throws InterruptedException
	{
			
		sleep(Constants.waittimeBeforeLogin);	
		driver.findElement(By.xpath("//input[@id='txtLoginId']")).sendKeys(Constants.Usename);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Constants.Password);
		driver.findElement(By.xpath("//input[@id='txtInput']")).click();
		sleep(Constants.captchawaittime);
		driver.findElement(By.xpath("//input[@id='signin']")).click();
		System.out.println("Successfully Login");
		sleep(Constants.waittimeAfterLogin);
	}

	

}
