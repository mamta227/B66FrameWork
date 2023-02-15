package day28;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo5 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//reading data from excel
		Workbook wb=WorkbookFactory.create(new File("./data/Book1.xlsx"));
		String un=wb.getSheet("login").getRow(1).getCell(0).getStringCellValue();
		String pw=wb.getSheet("login").getRow(1).getCell(1).getStringCellValue();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.id("UserName")).sendKeys(un);
		driver.findElement(By.name("PassWord")).sendKeys(pw);
		driver.findElement(By.id("loginButton")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.titleContains("Enter"));
		String aTitle=driver.getTitle();
		driver.quit();
		
		//writing data back to excel
		wb.getSheet("login").getRow(1).createCell(2).setCellValue(aTitle);
		wb.write(new FileOutputStream("./data/Book1.xlsx"));//save
		wb.close();
	}

}
