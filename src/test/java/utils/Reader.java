package utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;


/**
* The class which manages reading data from external sources. It currently manages Config file and Test data.
* @version 1.0
* @author Hussein ElSherif
*/
public class Reader {

    /**
     * This method gets a property from the config file by specifying the key to that property.
     * @param Key which retrievesthe data from the config file
     * @return String property from the config file
     */
	public static String getProperty(String key) throws IOException {
		InputStream input = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(input);
		return prop.getProperty(key);
	}

    /**
     * This method reads the data from the Test Data file provided in the config file. This is gathering the data in a 2D array and feeding it
     * to the JUnit test case paramaterized class.
     * @return 2D array representing the excel file's cells.
     */
	public static String[][] readDataFromExcel() throws IOException {
		// Create a workbook instances
		InputStream input = new BufferedInputStream(new FileInputStream(Reader.getProperty("dataPath")));
		// create new file system
		POIFSFileSystem fs = new POIFSFileSystem(input);
		// create new workbook
		HSSFWorkbook wb = new HSSFWorkbook(fs);
		// get sheet
		HSSFSheet sheet = wb.getSheetAt(0);

		int lastRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).getLastRowNum();

		// create the data array to return
		String[][] data = new String[lastRow][sheet.getRow(0).getLastCellNum()];

		// get rows
		for (int i = 0; i < lastRow; i++) {
			//read from +1 as we don't take the first row of headers.
			Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).getRow(i+1);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell != null) {
					if (cell.getCellType().toString() != "BLANK") {
						if (cell.getCellType().toString() == "NUMERIC") {
							data[i][j] = Long.toString((long) cell.getNumericCellValue());
						} else {
							data[i][j] = cell.toString();
						}
					} else
						continue;
				}
			}
		}
		wb.close();
		return data;
	}

}
