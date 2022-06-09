package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
	
		driver.findElement(By.xpath("//input[@name=\"emailAddress\"]")).sendKeys("v.m@gmail.com");
		
	
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).click();
				
		String Lead1 = driver.findElement(By.id("viewLead_firstName_sp")).getText();

		driver.findElement(By.xpath("//div[contains(@class,'frameSectionExtra')]/a[contains(text(),'Duplicate Lead')]")).click();

		String title = driver.getTitle();
		
		if (title.contains("Duplicate Lead"))
		{
			System.out.println("Title matched as Duplicate Lead");
		} else {
			System.out.println("Title is not matched");
		}
	
		driver.findElement(By.name("submitButton")).click();
	
		String Lead2 = driver.findElement(By.id("viewLead_firstName_sp")).getText();
	
		if (Lead1.equals(Lead2))
		{
			System.out.println("duplicated lead name is same as captured name");
		} else {
			System.out.println("duplicated lead name is not same as captured name");
		}
	
		driver.close();

	}

}