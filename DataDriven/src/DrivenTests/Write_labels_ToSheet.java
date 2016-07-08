package DrivenTests;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Write_labels_ToSheet {
	
	public void Writetoexcel(){
		File f= new File("writing_sheet1.xls");
		try {
			WritableWorkbook wwb=Workbook.createWorkbook(f);
			
			WritableSheet wsh=wwb.createSheet("results", 0);
			Label un=new Label(0, 0, "username");
			Label pn=new Label(1, 0, "password");
			Label rs=new Label(2, 0, "results");
			
			wsh.addCell(un);
			wsh.addCell(pn);
			wsh.addCell(rs);
			wwb.write();
			wwb.close();
		} catch (IOException | WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public static void main(String[] args) {
		
		Write_labels_ToSheet write=new Write_labels_ToSheet();
		write.Writetoexcel();

	}

}
