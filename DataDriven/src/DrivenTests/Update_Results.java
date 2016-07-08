package DrivenTests;

import java.io.File;
import java.io.IOException;

import org.hamcrest.core.StringContains;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Update_Results {

	public static void main(String[] args) throws IOException, BiffException, RowsExceededException, WriteException {
		File f= new File("Strings.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		
		WritableWorkbook wwb=Workbook.createWorkbook(f, wb);
		WritableSheet wsh=wwb.getSheet(0);
		
		int nor =sh.getRows();
		int noc =sh.getColumns();
		
		System.out.println(nor);
		System.out.println(noc);
		Label Criteria=new Label(2, 0, "Criteria");
		wsh.addCell(Criteria);
		
		for(int i=1;i<nor;i++)
		{
			String x=sh.getCell(0,i).getContents();
			String y=sh.getCell(1,i).getContents();
			
			
			
			

	}

}
}
