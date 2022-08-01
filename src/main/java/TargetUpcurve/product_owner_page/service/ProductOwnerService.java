package TargetUpcurve.product_owner_page.service;

import TargetUpcurve.product_owner_page.model.ProductOwner;

import java.util.List;

public interface ProductOwnerService {
    List<ProductOwner> getAllProductOwners();
    ProductOwner saveProductOwner(ProductOwner productOwner);
    ProductOwner getProductOwnerById(Long product_owner_id);
    ProductOwner updateProductOwner(ProductOwner productOwner);
    void deletePOById(Long product_owner_id);
}
