package Hexa.Rest_Assured_API;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {

	 public static FileInputStream fi;
	    public static FileOutputStream fo;
	    public static XSSFWorkbook wb;
	    public static XSSFSheet ws;
	    public static XSSFRow rows;
	    public static XSSFCell cell;
	    
	    public static int getRowCount(String xlfile, String xlsheet) throws IOException
	    {
	        fi=new FileInputStream(xlfile);
	        wb=new XSSFWorkbook(fi);
	        ws=wb.getSheet(xlsheet);
	        int rowcount=ws.getLastRowNum();
	        wb.close();
	        fi.close();
	        return rowcount;
	    }
	    
	    public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	    {
	        fi=new FileInputStream(xlfile);
	        wb=new XSSFWorkbook(fi);
	        ws=wb.getSheet(xlsheet);
	        rows=ws.getRow(rownum);
	        int cellcount=rows.getLastCellNum();
	        wb.close();
	        fi.close();
	        return cellcount; 
	    }
	    
	    public static String getCelldata(String xlfile, String xlsheet, int rownum,int colnum) throws IOException
	    {
	        fi=new FileInputStream(xlfile);
	        wb=new XSSFWorkbook(fi);
	        ws=wb.getSheet(xlsheet);
	        rows=ws.getRow(rownum);
	        cell=rows.getCell(colnum);
	        String data;
	        try
	        {
	            DataFormatter formatter=new DataFormatter();
	            String cellData= formatter.formatCellValue(cell);
	            return cellData;
	        }
	        catch(Exception e)
	        {
	            data="";
	        }
	    wb.close();
	    fi.close();
	    return data;
	    }
	    
	    public static void setCellData(String xlfile, String xlsheet, int rownum,int colnum,String data) throws IOException
	    {
	        fi=new FileInputStream(xlfile);
	        wb=new XSSFWorkbook(fi);
	        ws=wb.getSheet(xlsheet);
	        rows=ws.getRow(rownum);
	        cell=rows.createCell(colnum);
	        cell.setCellValue(data);
	        fo=new FileOutputStream(xlfile);
	        wb.write(fo);
	        wb.close();
	        fi.close();
	        fo.close();
	        
	    }
	}