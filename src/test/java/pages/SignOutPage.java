package pages;

import org.openqa.selenium.By;

import base.CommonLibs;

public class SignOutPage extends CommonLibs {
	
public void Logout() {		
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//*[@id='nbilogout']")).click();
		driver.switchTo().alert().accept();
		System.out.println("Application has logout !!!");
		
	}

}
