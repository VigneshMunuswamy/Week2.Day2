package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement javacb = driver.findElement(By.xpath("//div[1]/input[1]"));
		javacb.click();
		boolean javaSel = javacb.isSelected();
		if (javaSel == true){
			System.out.println("Java option is checked");
		}

		driver.findElement(By.xpath("//div[1]/input[3]")).click();
		boolean sqlSel = driver.findElement(By.xpath("//div[1]/input[3]")).isSelected();
		if (sqlSel == true){
			System.out.println("SQL option is checked");
		}


		boolean selSel = driver.findElement(By.xpath("//div[1]/input[3]")).isSelected();
		if (selSel == true){
			System.out.println("Selenium option is checked");
		}
		else {
			driver.findElement(By.xpath("//div[1]/input[3]")).click();
		}

		Boolean opt1 = driver.findElement(By.xpath("//div[3]/input[1]")).isSelected();
		if (opt1==false)
			System.out.println("The Option 1 is unchecked");
		else {
			System.out.println("The Option 1 is checked but it will be unchecked");
			driver.findElement(By.xpath("//div[3]/input[1]")).click();
		}
		Boolean opt2 = driver.findElement(By.xpath("//div[3]/input[2]")).isSelected();
		if (opt2==false)
			System.out.println("The Option 2 is unchecked");
		else {
			System.out.println("The Option 2 is checked but it will be unchecked");
			driver.findElement(By.xpath("//div[3]/input[2]")).click();
		}

		List<WebElement> chkbox = driver.findElements(By.xpath("//div[4]/input[@type='checkbox']"));
		int chksize = chkbox.size();
		System.out.println("The total options present in 4th question: "+chksize);


		for (int i=1;i<=chksize;i++) {
			Boolean opt=driver.findElement(By.xpath("//div[4]/input[" + i + "]")).isSelected();
			if(opt==true)
				System.out.println("The Option " + i + " is already checked");
			else {
				System.out.println("The Option 2 will be checked now");
				driver.findElement(By.xpath(("//div[4]/input[" + i + "]"))).click();
			}
		}


	}
}

