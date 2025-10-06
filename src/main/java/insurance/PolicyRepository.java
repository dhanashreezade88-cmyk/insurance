package insurance;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Entity_Class, Integer> {
    List<Entity_Class> findByPremiumAmount(Double premiumAmount);
    List<Entity_Class> findByStatusIgnoreCase(String status);
    
    
}