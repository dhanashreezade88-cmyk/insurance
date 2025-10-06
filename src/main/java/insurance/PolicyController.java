package insurance;
import org.springframework.core.io.InputStreamResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    // Get all policies
    @GetMapping("/all")
    public List<Entity_Class> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    // Get policies by premium amount
    @GetMapping("/premium")
    public List<Entity_Class> getPoliciesByPremiumAmount(@RequestParam Double amount) {
        return policyService.getPoliciesByPremiumAmount(amount);
    }

    // Add new policy
    @PostMapping("/add")
    public Entity_Class addPolicy(@RequestBody Entity_Class policy) {
        return policyService.savePolicy(policy);
    }

    // ✅ Export matured policies to Excel
    @GetMapping("/export/matured")
    public ResponseEntity<InputStreamResource> exportMaturedPolicies() throws IOException {
        List<Entity_Class> maturedPolicies = policyService.getPoliciesByStatus("matured");
        ByteArrayInputStream in = policyService.exportPoliciesToExcel(maturedPolicies);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=matured_policies.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .body(new InputStreamResource(in));
    }


}
