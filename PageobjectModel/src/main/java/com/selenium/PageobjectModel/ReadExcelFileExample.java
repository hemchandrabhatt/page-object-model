package com.selenium.PageobjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcelFileExample {

	@SuppressWarnings("deprecation")
	public static <XSSFWorkbook> void main(String[] args) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Sample sheet");

		Map<String, Object[]> data = new HashMap<String, Object[]>();
		data.put("1", new Object[] { "Emp No.", "Name", "Salary" });
		data.put("2", new Object[] { 1d, "John", 1500000d });
		data.put("3", new Object[] { 2d, "Sam", 800000d });
		data.put("4", new Object[] { 3d, "Dean", 700000d });

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = data.get(key);
			int cellnum = 0; 
			for (Object obj : objArr) {
				org.apache.poi.ss.usermodel.Cell cell = row
						.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj); 
			}
		}

		try {
			FileOutputStream out = new FileOutputStream(
					new File(
							"E:\\Java-Programs\\PageobjectModel\\src\\main\\java\\com\\selenium\\PageobjectModel\\TestDataFile1.xls"));
			workbook.write(out);

			out.close();
			System.out.println("Excel written successfully..");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			FileInputStream file = new FileInputStream(new File("E:\\Java-Programs\\PageobjectModel\\src\\main\\java\\com\\selenium\\PageobjectModel\\TestDataFile1.xls"));

			// Get the workbook instance for XLS file
			HSSFWorkbook workbook1 = new HSSFWorkbook(file);

			// Get first sheet from the workbook
			HSSFSheet sheet1 = workbook1.getSheetAt(0);

			// Iterate through each rows from first sheet
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();

				// For each row, iterate through each columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING:
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
						
						//cell.
					}
				}
				System.out.println("");
			}
			file.close();
			FileOutputStream out = new FileOutputStream(
					new File("C:\\test.xls"));
			workbook.write(out);
			out.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
