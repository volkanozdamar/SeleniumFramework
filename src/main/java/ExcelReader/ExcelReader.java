package ExcelReader;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tinylog.Logger;


public class ExcelReader {
    static int rowCount;
    static String excelPath = System.getProperty("user.dir")+"/src/resources/excel/data.xlsx";
    static String cellValue;
    public static void main(String[] args) {
        getRowCount();
        getRowData("Sheet1",1,1);
    }


    public static int getRowCount() {
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            rowCount = sheet.getPhysicalNumberOfRows();
            Logger.info("Row Count is "+rowCount);
            workbook.close();
        }
        catch (Exception e){
            Logger.error("Messege : "+e.getMessage());
            Logger.error("Cause : "+e.getCause());
        }
        return rowCount;
    }
    public static String getRowData(String sheetName,int rowNum,int cellNum){
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
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
