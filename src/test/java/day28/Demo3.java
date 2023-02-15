package day28;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo3 {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Workbook wb=WorkbookFactory.create(new File("./data/Book1.xlsx"));
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<2;j++)
			{
				String v=wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
				System.out.print(v+" ");
			}
			System.out.println();
		}
		wb.close();
	}
	
	

}
