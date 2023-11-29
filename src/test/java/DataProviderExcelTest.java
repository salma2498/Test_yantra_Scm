

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.scmflex.Genericutils.IPathConstants;

public class DataProviderExcelTest {
	@DataProvider
	public Object[][] data() throws Throwable
	{
		FileInputStream fi=new FileInputStream(IPathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Sheet2");
		int rowcount = sh.getPhysicalNumberOfRows();
		int cellcount = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for (int j = 0; j < cellcount; j++) 
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;
	}

}
