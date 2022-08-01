package TargetUpcurve.product_owner_page.repository;

import TargetUpcurve.product_owner_page.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductOwnerRepository extends JpaRepository<ProductOwner,Long> {

}
