package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EditLead {

	public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver= new ChromeDriver();
	
	driver.get("http://leaftaps.com/opentaps/control/main");
	
	driver.manage().window().maximize();

	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");

	driver.findElement(By.xpath("//input[@type='password']")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@type='submit']")).click();

	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	Thread.sleep(3000);
	
	//Creating lead b4 duplicate
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vignesh");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("M");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("VM");
			driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing Team");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("I'm from Chennai");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("v.m@gmail.com");
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("8148260716");
			WebElement srclist = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select srclist1 = new Select(srclist);
			srclist1.selectByVisibleText("New York");
			driver.findElement(By.className("smallSubmit")).click();
			
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div/div/div/div/div/div[1]/form/div/div[2]/div/div[1]/div/div/div[2]/div[1]/input")).sendKeys("Vignesh");
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).click();
			// confirm  the title of the page
			if (driver.getTitle().contains("CRM")) {
				System.out.println("the title is confirmed");
			}
			else {
				System.out.println("the title is not confirmed");
			}
		
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
			
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
	
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Leaf");
			String text = driver.findElement(By.id("updateLeadForm_companyName")).getText();
			Thread.sleep(2000); 
			System.out.println(text);
			
			driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
			
			String changeText = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			System.out.println(text);
			System.out.println(changeText); 
			if (changeText.contains(text))
			{ 
				System.out.println(" Changed Text is confirmed");
			} else { System.out.println(" Change Text is not confirmed"); }
			
	         driver.close();
}
}