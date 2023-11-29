package Practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the data");
	    String data = sc.nextLine();
		
		FileInputStream fi=new FileInputStream("./src/test/resources/WriteexcelData.xlsx");
		Workbook wh = WorkbookFactory.create(fi);
		Sheet sh = wh.getSheet("sheet1");
		sh.createRow(0).createCell(0).setCellValue(data);
		FileOutputStream fout=new FileOutputStream("./src/test/resources/WriteexcelData.xlsx");
		wh.write(fout);
		wh.close();
		fout.close();
		System.out.println("Data entered successfully");
		
		

	}

}
