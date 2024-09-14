import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C30_ApachePoi {

    @Test
    public void readExcelTest() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/resources/Students.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet gradeSheet = workbook.getSheet("Grade");

        Row row9 = gradeSheet.getRow(8);

        Cell r9c2 = row9.getCell(1);

        System.out.println("r9c2 = " + r9c2);

        Cell r16c3 = gradeSheet.getRow(15).getCell(2);

        System.out.println("r16c3 = " + r16c3);

        System.out.println("--All Rows--");

        for (Row w : gradeSheet) {

            System.out.print("| ID: "+w.getCell(0));
            System.out.print("| Name: "+w.getCell(1));
            System.out.println("| Grade: "+w.getCell(2));

        }

        workbook.close();

    }

    @Test
    public void writeExcelTest() throws IOException {

        FileInputStream fis = new FileInputStream("src/test/resources/Students.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet gradeSheet = workbook.getSheet("Grade");

        gradeSheet.getRow(0).createCell(3).setCellValue("Address");

        for (int i = 1; i<=gradeSheet.getLastRowNum(); i++){

            gradeSheet.getRow(i).createCell(3).setCellValue(Faker.instance().address().city());

        }

        FileOutputStream fos = new FileOutputStream("src/test/resources/Students.xlsx");

        workbook.write(fos);

        workbook.close();

    }

    @Test
    public void createSheetTest() throws IOException {

        Workbook workbook = WorkbookFactory.create(true);

        workbook.createSheet("New Sheet").createRow(3).createCell(2).setCellValue("Hello World");

        FileOutputStream fos = new FileOutputStream("src/test/resources/newExcel.xlsx");

        workbook.write(fos);

        workbook.close();

    }

}
