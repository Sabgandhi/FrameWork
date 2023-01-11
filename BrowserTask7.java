package org.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.task.BrowserSeleium;





public class BrowserTask7 extends BrowserSeleium  {

	public static void main(String[] args) throws IOException {
		launchChrome();
		winmax();
		loadurl("https://www.facebook.com/\r\n"
				+ "");
		printTitle();
		 printcurrenturl();
		 WebElement user = driver.findElement(By.id("email"));
		 fill(user, getData(0, 1));
		 
		 WebElement pass = driver.findElement(By.id("pass"));
		 fill(pass, getData(1, 1));
		 
		 WebElement login = driver.findElement(By.name("login"));
		 login.click();
		 
		 WebElement error = driver.findElement(By.xpath("//div[@class='_9ay7']"));
		 String text = error.getText();
		 System.out.println(text);
		File f =new File("E:\\eclipse\\sabari\\Frame\\target\\testdata\\update.xlsx");
		boolean c = f.createNewFile();
		System.out.println(c);
		
		//2.Type of Workbook
		
		Workbook w=new XSSFWorkbook();
		//3.Create the sheet
		Sheet s=w.createSheet("Insert");
		Row r=s.createRow(4);
		
	Cell cell=r.createCell(5);
	System.out.println("Success");
	cell.setCellValue(text);
	
	FileOutputStream fout=new FileOutputStream(f);
	
	w.write(fout);
	System.out.println("sucess");
		
		
		
		
		
		
		
		
	}


	
	
	
	
	
}
