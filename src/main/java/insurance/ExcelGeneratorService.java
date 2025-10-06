package insurance;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelGeneratorService {

    public ByteArrayInputStream generateExcel(List<Entity_Class> policies) throws IOException {
        String[] columns = {"Policy ID", "Policy Number", "Policy Holder", "Premium Amount", "Status"};

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Policies");

            // Header Row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Data Rows
            int rowIdx = 1;
            for (Entity_Class policy : policies) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(policy.getPolicyId());
                row.createCell(1).setCellValue(policy.getPolicyNumber());
                row.createCell(2).setCellValue(policy.getPolicyHolder());
                row.createCell(3).setCellValue(policy.getPremiumAmount());
                row.createCell(4).setCellValue(policy.getStatus());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
