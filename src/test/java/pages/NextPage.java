package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import base.CommonLibs;
import generics.Constants;

public class NextPage extends CommonLibs {

	public void Next_Page() throws InterruptedException {
		
		
		try {
			driver.findElement(By.xpath("//*[text()='"+Constants.courseName+"']")).click();

			sleep(Constants.courseLoading);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("fraebookcontent");

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='cssbreadcrumbitem'][contains(text(), 'Next')]")));

			Reporter.log("Loop has been started !!!", true);
			boolean hasNextPage = true;
				
				while (hasNextPage) {
					List<WebElement> enabled_next_page_btn = driver
						.findElements(By.xpath("//span[@class='cssbreadcrumbitem'][contains(text(), 'Next')]"));
					if (enabled_next_page_btn.size() > 0) {
						enabled_next_page_btn.get(0).click();
						//waitTime(Constants.waitforNextPage);
						Thread.sleep(3000);
						hasNextPage = true;
					} else {
						hasNextPage = false;
						System.out.println("No more Pages Available");
					}
				}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		}

	}

}
