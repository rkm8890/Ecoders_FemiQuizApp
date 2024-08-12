package generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelCode implements Constants {
  
    public static Object getData(String sheetname, int rownumber, int cellnumber) {
        Object value = null;
        try {
            File f = new File(excelSheetPath);
            FileInputStream fis = new FileInputStream(f);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sh = wb.getSheet(sheetname);
            Row row = sh.getRow(rownumber);
            Cell cell = row.getCell(cellnumber);
            CellType celltype = cell.getCellType();
            
            switch (celltype) {
                case STRING:
                    value = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    value = cell.getNumericCellValue();
                    break;
                case BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case FORMULA:
                    value = cell.getCellFormula();
                    break;
                case BLANK:
                    value = null;
                    break;
                default:
                    value = null;  // In case of BLANK or other types
            }
            wb.close(); // Ensure the workbook is closed after use
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }
}
