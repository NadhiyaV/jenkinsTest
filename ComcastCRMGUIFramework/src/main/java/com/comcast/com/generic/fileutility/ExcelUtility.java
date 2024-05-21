package com.comcast.com.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDatafromExcel(String sheet_name,int row_num,int col_num) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./testdata/ORGANIZATION.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String data=wb.getSheet(sheet_name).getRow(row_num).getCell(col_num).getStringCellValue();
		wb.close();
		return data;
		
	}
	
	public int getRowCount(String sheet_name) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./testdata/ORGANIZATION.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheet_name).getLastRowNum();
		wb.close();
		return rowcount;
		
	}
	public void setDataIntoExcel(String sheet_name,int row_num,int cell_num,String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream("./testdata/ORGANIZATION.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheet_name).getRow(row_num).createCell(cell_num);
		
		FileOutputStream fos= new FileOutputStream("./testdata/ORGANIZATION.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
