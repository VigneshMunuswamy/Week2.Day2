package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		String mainUrl = driver.getCurrentUrl();
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[1]/div/div/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
		driver.get(mainUrl);

		String getUrl = driver.findElement(By.xpath("//a[text() =\"Find where am supposed to go without clicking me?\"]")).getAttribute("href");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text() =\"Find where am supposed to go without clicking me?\"]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String checkUrl = driver.getCurrentUrl();
		if (getUrl.equals(checkUrl))
			System.out.println("Links are directed to the same page");
		else
			System.out.println("Links are directed to different pages");
		
		System.out.println("the 2nd Link redirects to - "+getUrl);
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[3]/div/div/a")).click();
		String currenttitle = driver.getTitle();
		if (currenttitle.equals("404 Not Found"))
			System.out.println("The link is broken");
		driver.get(mainUrl);
		
		driver.findElement(By.xpath("//*[@id=\"contentblock\"]/section/div[4]/div/div/a")).click();
		
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));
		int count = 0;
		for (int i = 0; i < totalLinks.size(); i++) {
			count = count + 1;
		}
		System.out.println("Total link count using for method: " + count);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total link count using list size method "+links.size());
		 driver.close();
	}

}
