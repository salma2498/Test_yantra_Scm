package Practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Readthedatafromexcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fi=new FileInputStream("./src/test/resources/Exceldata.xlsx");
		Workbook wh = WorkbookFactory.create(fi);
		Sheet sh = wh.getSheet("Sheet1");
		String value = sh.getRow(1).getCell(0).getStringCellValue();
		System.out.println(value);
		
		

	}

}
