package insurance;
import insurance.Entity_Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public List<Entity_Class> getAllPolicies() {
        return policyRepository.findAll();
    }

    @Override
    public List<Entity_Class> getPoliciesByPremium(Double premium) {
        return policyRepository.findByPremiumAmount(premium);
    }

    @Override
    public List<Entity_Class> getPoliciesByPremiumAmount(Double premiumAmount) {
        return policyRepository.findByPremiumAmount(premiumAmount);
    }

    @Override
    public Entity_Class savePolicy(Entity_Class policy) {
        return policyRepository.save(policy);
    }

    @Override
    public List<Entity_Class> getPoliciesByStatus(String status) {
        return policyRepository.findByStatusIgnoreCase(status);
    }

    @Override
    public ByteArrayInputStream exportPoliciesToExcel(List<Entity_Class> policies) throws IOException {
        String[] columns = {"Policy ID", "Policy Number", "Policy Holder", "Premium Amount", "Status"};

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Matured Policies");

            // Header row
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowIdx = 1;
            for (Entity_Class policy : policies) {
            	if (policy.getStatus() != null && policy.getStatus().trim().equalsIgnoreCase("matured")) { // Only matured policies
                    Row row = sheet.createRow(rowIdx++);

                    row.createCell(0).setCellValue(policy.getPolicyId());
                    row.createCell(1).setCellValue(policy.getPolicyNumber());
                    row.createCell(2).setCellValue(policy.getPolicyHolder());
                    row.createCell(3).setCellValue(policy.getPremiumAmount());
                    row.createCell(4).setCellValue(policy.getStatus());
                }
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
