	package com.scp.util;
	
	import java.io.IOException;
	import java.util.Iterator;
	
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
	public class ReadDataFromExcelUtil {
	
			public static void main(String[] args) {
				readTestData();
			}
			
			
			public static Object[][] readTestData(){
				//Object [][] testData = new Object[row][coln];
				Object [][] testData = new Object[10][3];
				//11 -- No of records
				//3 -- No of values in each record
											//0=numeric;1=string;true/false=boolean
				int rowCount = 0;
				int cellCount = 0;
				
				XSSFWorkbook workbook = null;
				try {
					workbook = new XSSFWorkbook("E:\\sushil.xlsx");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				try{
					XSSFSheet sheet = workbook.getSheet("sheet1");
					Iterator<Row> rows = sheet.iterator();
					
					boolean flag = true;
					
					while(rows.hasNext()){
							Row singleRow = rows.next();
							if(flag){
							flag=false; //just to skip thead
							continue;
							}
								//0-String ,1=numeric	
							
							System.out.println("\n");
							Iterator<Cell> cells = singleRow.iterator();
							while(cells.hasNext()){
								Cell singleCell = cells.next();
							if(singleCell.getCellType()==0){
								System.out.print((int)singleCell.getNumericCellValue() +" | ");
								
								}else if(singleCell.getCellType()==1){
	
							String cellValue = singleCell.getStringCellValue().equals("NA") ? null : singleCell.getStringCellValue();
															
							/*	if("S.No".equals(cellValue))
								continue;*/
											testData[rowCount][cellCount] = cellValue;
													cellCount++;
												System.out.print(cellValue +" | ");
												}else{
												//System.out.println("Invalid cell type -- "+singleCell.getCellType());
												}
											}
											rowCount++;
											cellCount=0;
					}	
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					try {
						if(workbook!=null)
							workbook.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				return testData;
			}
		}
	
