package com.sa.helper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class Helper {
	
	
	public static String[] getHeader(Object object)
	{
		Class<?> class1 = object.getClass();
		
		Field[] declaredFields = class1.getDeclaredFields();
		
		String setFlides[]= new String[declaredFields.length];
		for(int i=0;i<setFlides.length;i++)
		{
			setFlides[i]=declaredFields[i].getName();
		}
		
		
		return setFlides;
	}
		
	
	public static ByteArrayInputStream datatoexcel(String[] header, Map<String, Map<String, Boolean>> attendanceDetails ) throws IOException
	{
		String[] HEADERS = header;

		Workbook workbook= new XSSFWorkbook();
		
		ByteArrayOutputStream out=new ByteArrayOutputStream();
		try
		{
			
			
			Sheet createSheet = workbook.createSheet("Student attendence Sheet");
			
			

			Row row = createSheet.createRow(0);
			
			for(int i=0;i<HEADERS.length;i++)
			{
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			
			int rowIndex=1;
			for(String obj:attendanceDetails.keySet())
			{
				{
					
					Map<String, Boolean> map = attendanceDetails.get(obj);
					Row createRow = createSheet.createRow(rowIndex);
					int i=0;
					Cell cell1 = createRow.createCell(i);
							cell1.setCellValue(obj);
					for(int k=1;k<HEADERS.length;k++)
					{
						Cell cell = createRow.createCell(i+1);
						Boolean flag=true;
						for(String x:map.keySet())
						{
							if(HEADERS[k].equals(x))
							{
								if(map.get(x))
								{
									cell.setCellValue("Present");
									flag=false;
									break;
								}
								else if(map.get(x))
								{
									cell.setCellValue("Absent");
									flag=false;
									break;
								}
								else
								{
									cell.setCellValue("N/A");
									flag=false;
									break;
								}
								
							}
						}
							i++;
						if(flag)
						{
							cell.setCellValue("N/A");
						}
						
					}
					rowIndex++;
					
					
				}
			
				
				 
			}
			
			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
			
			
			
					
		} 
		catch(Exception e) {
			
			e.printStackTrace();
			
			System.out.println("falid to export datas");
			
		}
		finally {
			workbook.close();
		}
		
		
		return null;
	}
}

	
//	int rowIndex=1;
//	for(Object obj:objlist)
//	{
//		Field[] declaredFields = obj.getClass().getDeclaredFields();
//		Row createRow = createSheet.createRow(rowIndex);
//		
//		for(int i=0;i<declaredFields.length;i++)
//		{
//			
//			Field field = declaredFields[i];
//			Object object = field.get(obj);
//			
//			
//				Cell cell = createRow.createCell(i);
//				cell.setCellValue(object.toString());
//			
//			
//			
//		}
//		rowIndex++;
//		
//		 
//	}
//	
//	workbook.write(out);
//	return new ByteArrayInputStream(out.toByteArray());
//	
//	
//	
//			
//} 
	
	
	
	
	
	

