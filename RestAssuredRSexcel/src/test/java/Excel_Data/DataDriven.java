package Excel_Data;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public ArrayList<String> getdata(String test) throws IOException {

        ArrayList<String> arr=new ArrayList<>();
        //through this i got object of my excel file
        FileInputStream file=new FileInputStream("C:\\Users\\USER\\IdeaProjects\\Cucumber\\RestAssuredRS\\exceldata.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(file);

        //number of sheets present in excel file
        int sheets=workbook.getNumberOfSheets();
        XSSFSheet sheet;

        for(int i=0; i<sheets; i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("testdata")){
                sheet=workbook.getSheetAt(i);
                //now since we got the sheet now our aim is to get the data of specific testcase
                // 1. Identify test case column by scanning 1st row
                // 2. once u got column scan it and grab specifc test case
                // 3. once u got specific row get its data

                //1.
                // i need to iterate the row by using iterator object with return type row
                Iterator<Row> rows=sheet.iterator();
                // row ko row by row jane ke liye row.next karna parta ha jo jb first time row.next kronga tu i will come on 1st row
                Row firstrow=rows.next();
                //ab jaise kam row ke liye kia thaa by using iterator same yehi kam cell ke liya hoga
                Iterator<Cell> cells=firstrow.cellIterator();
                //cells.next();
                int k=0;
                int column=0;
                //cells.next krne se testcase pr ayega, phr next krne se data1 etc
                // ab hum eik loop ma dalenge isko taake hum cell by cell move kre so we will use cell.hasnext() which only checks whether other cell is present or not
                while(cells.hasNext()){
                    Cell value=cells.next();
                    //2.
                    //get the string value of cell
                    if(value.getStringCellValue().equalsIgnoreCase("Testcases")){
                        //desired column
                        column=k;
                    };
                    k++;
                }
                //System.out.println(column);

                while (rows.hasNext()){
                    //3.
                    Row r= rows.next();
                    if(r.getCell(column).getStringCellValue().equalsIgnoreCase(test)){
                        Iterator<Cell> cell= r.cellIterator();
                        while(cell.hasNext()){
                            Cell c=cell.next();
                            //System.out.println(c.getStringCellValue());
                            if(c.getCellTypeEnum()== CellType.STRING) {
                                arr.add(c.getStringCellValue());
                            }
                            else{
                                arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }

            }
        }
        return arr;
    }

    public static void main(String[] args) throws IOException{


    }



}
