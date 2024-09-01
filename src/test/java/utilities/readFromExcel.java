package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFromExcel {
	String path;
	FileInputStream f;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public readFromExcel(String path)
	{
		this.path=path;
	}
	public int getrowCound(String sheetname) throws IOException
	{
	    f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sheet = wb.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		wb.close();
		f.close();
		return lastrow; 
	}
	
	public int getcolCount(String sheetname, int row) throws IOException
	{
		f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sheet = wb.getSheet(sheetname);
		int lastrow = sheet.getLastRowNum();
		int colno=sheet.getRow(row).getLastCellNum();
		wb.close();
		f.close();
		return colno;
	}
	
	public String getCellData(String sheetname, int row, int col) throws IOException
	{
		f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sheet = wb.getSheet(sheetname);
		XSSFRow row1= sheet.getRow(row);
		XSSFCell col1 = row1.getCell(col);
		String data;
		DataFormatter formatter =  new DataFormatter();
		try
		{
			data=formatter.formatCellValue(col1);
		}
		catch(Exception e)
		{
			data=" ";
		}
		wb.close();
		f.close();
		return data;
	}
	
	public void writeToExcel(String sheetname, int row, int col,String data) throws IOException
	{
		f = new FileInputStream(path);
		wb = new XSSFWorkbook(f);
		sheet = wb.getSheet(sheetname);
		XSSFRow row1= sheet.getRow(row);
		XSSFCell cellc = row1.createCell(col);
		cellc.setCellValue(data);
		FileOutputStream f1= new FileOutputStream(path);
		wb.write(f1);
		wb.close();
		f.close();
	}

}
