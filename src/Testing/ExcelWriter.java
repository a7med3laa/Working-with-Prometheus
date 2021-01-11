package Testing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelWriter {

	int num;
	Workbook workbook;
	Sheet sheet;

	public ExcelWriter() {
		// TODO Auto-generated constructor stub
		num = 0;
		workbook = new HSSFWorkbook();
		sheet = workbook.createSheet();
	}

	public void writeMetric(Metric aBook) throws IOException {

		Row row = sheet.createRow(++num);

		Cell cell = row.createCell(1);
		cell.setCellValue(aBook.getThroughput());

		cell = row.createCell(2);
		cell.setCellValue(aBook.getCPU());

		cell = row.createCell(3);
		cell.setCellValue(aBook.getMemory());

		cell = row.createCell(4);
		cell.setCellValue(aBook.getLoad());
		try (FileOutputStream outputStream = new FileOutputStream("Test Result.xls")) {
			workbook.write(outputStream);
		}
	}

}
