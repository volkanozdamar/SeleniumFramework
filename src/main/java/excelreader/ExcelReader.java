package excelreader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tinylog.Logger;


public class ExcelReader {
    static int rowCount;
    static String excelPath = System.getProperty("user.dir")+"/src/resources/excel/data.xlsx";
    static String cellValue;
    private ExcelReader() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Return rowcount for new spreatsheet formats , Microsoft Excel version 2007 and later.
     *
     * @return
     */
    public static int getRowCount(String sheetname) {
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath)){
            XSSFSheet sheet = workbook.getSheet(sheetname);
            rowCount = sheet.getPhysicalNumberOfRows();
            Logger.info("Row Count is "+rowCount);
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return rowCount;
    }

    /**
     * Reads new spreatsheet formats , Microsoft Excel version 2007 and later.
     * @param sheetName
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getRowData(String sheetName,int rowNum,int cellNum){
        try(XSSFWorkbook workbook = new XSSFWorkbook(excelPath)){
            XSSFSheet sheet = workbook.getSheet(sheetName);
            cellValue = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
            Logger.info("Value for "+sheetName+"("+rowNum+","+cellNum+") is :"+cellValue);
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return cellValue;
    }
}
