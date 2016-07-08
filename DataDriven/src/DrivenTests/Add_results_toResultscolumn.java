package DrivenTests;

import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Add_results_toResultscolumn {

	public static void main(String[] args) throws BiffException, IOException, RowsExceededException, WriteException {
		File f= new File("Add_ int values.xls");
		Workbook wb=Workbook.getWorkbook(f);
		Sheet sh=wb.getSheet(0);
		
		WritableWorkbook wwb=Workbook.createWorkbook(f, wb);
		WritableSheet wsh=wwb.getSheet(0);
		
		int nor =sh.getRows();
		int noc =sh.getColumns();
		
		System.out.println(nor);
		System.out.println(noc);
		
		
		for(int i=1;i<nor;i++){
			String x=sh.getCell(0,i).getContents();
			String y=sh.getCell(1,i).getContents();
			
			int z=Integer.parseInt(x)+Integer.parseInt(y);
			
			Number n= new Number(2,i,z);
			wsh.addCell(n);
		}
		wwb.write();
		wwb.close();
		wb.close();
		

	}

}
