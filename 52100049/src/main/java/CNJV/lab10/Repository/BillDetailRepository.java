package CNJV.lab10.Repository;

import CNJV.lab10.model.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BillDetailRepository extends JpaRepository<BillDetail,Long> {
}
