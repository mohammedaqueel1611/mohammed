package com.hrms.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class General extends Global {
	public void openapplication() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://127.0.0.1/orangehrm-2.6/login.php");
		System.out.println("application opened");
	}
    public void closeapplication() {
    	driver.quit();
    	System.out.println("application closed");
    	
    }
    public void login()throws Exception {
    	driver.findElement(By.name(txt_loginname)).sendKeys(un);  
    	driver.findElement(By.name(txt_password)).sendKeys(pw); 
     	driver.findElement(By.name(btn_login)).click(); 
     	Thread.sleep(3000); 
       System.out.println("login successfully");
    }
    public void logout() {
    	driver.findElement(By.linkText("Logout")).click();
    	System.out.println("logout successfully");
    	
    }
    public void addemp() {
    	
    	WebElement frame1=driver.findElement(By.id("rightMenu"));
    	driver.switchTo().frame(frame1);
    	driver.findElement(By.xpath("//*[@id=\"standardView\"]/div[3]/div[1]/input[1]")).click();
    	String emp = driver.findElement(By.xpath("//input[@name='txtEmployeeId']")).getAttribute("value");
		System.out.println(emp);
    	driver.findElement(By.name("txtEmpFirstName")).sendKeys("mohammed");
    	driver.findElement(By.name("txtEmpLastName")).sendKeys("aqueel");
    	driver.findElement(By.name("photofile")).sendKeys("D:\\New folder (2)\\New folder\\20190112_075612.jpg");
    	driver.findElement(By.id("btnEdit")).click();
    	System.out.println("added employee");
    	driver.switchTo().defaultContent();
    	
    	
    }
    public void deleteemp()throws Exception {
    	
    	WebElement frame1=driver.findElement(By.id("rightMenu"));
    	driver.switchTo().frame(frame1);
    	Select st = new Select(driver.findElement(By.id("loc_code")));
    	st.selectByIndex(2);
		
		driver.findElement(By.id("loc_name")).sendKeys("Mohammed");
		driver.findElement(By.className("plainbtn")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//*[@id=\"standardView\"]/table/tbody/tr[1]/td[1]/input")).click();
		driver.findElement(By.xpath("//input[@class='plainbtn'][@value='Delete']")).click();
		System.out.println("employee deleted");
		driver.switchTo().defaultContent();
		
    }
}
