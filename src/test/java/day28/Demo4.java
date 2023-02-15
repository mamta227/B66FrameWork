package day28;

import java.io.File;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo4 {
	
	public static void main(String[] args) throws Exception {
		
		
		Workbook wb=WorkbookFactory.create(new File("./data/Book1.xlsx"));
		
		int rc=wb.getSheet("Sheet2").getLastRowNum();
		
		for(int i=0;i<=rc;i++)
		{
			try {
				int cc = wb.getSheet("Sheet2").getRow(i).getLastCellNum();
				for(int j=0;j<cc;j++)
				{
					try
					{
					 RichTextString v = wb.getSheet("Sheet2").getRow(i).getCell(j).getRichStringCellValue();
					 System.out.print(v+" ");
					}
					catch(NullPointerException e)
					{
						System.out.print("--");
					}
					
				}
			}
			catch(NullPointerException e)
			{
				System.out.print("-- --");
			}
			System.out.println();
			
		}
		wb.close();
		
	}
	
	

}
