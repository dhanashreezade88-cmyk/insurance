package insurance;
import insurance.Entity_Class;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

public interface PolicyService {
    List<Entity_Class> getAllPolicies();
    List<Entity_Class> getPoliciesByPremium(Double premium);
    Entity_Class savePolicy(Entity_Class policy);
    List<Entity_Class> getPoliciesByPremiumAmount(Double premiumAmount);
    List<Entity_Class> getPoliciesByStatus(String status);
    
    ByteArrayInputStream exportPoliciesToExcel(List<Entity_Class> policies) throws IOException;
}
