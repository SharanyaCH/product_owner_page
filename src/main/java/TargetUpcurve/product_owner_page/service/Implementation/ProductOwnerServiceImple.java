package TargetUpcurve.product_owner_page.service.Implementation;

import TargetUpcurve.product_owner_page.model.ProductOwner;
import TargetUpcurve.product_owner_page.repository.ProductOwnerRepository;
import TargetUpcurve.product_owner_page.service.ProductOwnerService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductOwnerServiceImple implements ProductOwnerService {

    private ProductOwnerRepository productOwnerRepository;

    //constructor
    public ProductOwnerServiceImple(ProductOwnerRepository productOwnerRepository){
        super();
        this.productOwnerRepository=productOwnerRepository;
    }

    @Override
    public List<ProductOwner> getAllProductOwners() {
        return productOwnerRepository.findAll();
    }

    @Override
    public ProductOwner saveProductOwner(ProductOwner productOwner) {
        return productOwnerRepository.save(productOwner);
    }

    @Override
    public ProductOwner getProductOwnerById(Long product_owner_id) {
        return productOwnerRepository.findById(product_owner_id).get();
    }

    @Override
    public ProductOwner updateProductOwner(ProductOwner productOwner) {
        return productOwnerRepository.save(productOwner);
    }

    @Override
    public void deletePOById(Long product_owner_id) {
        productOwnerRepository.deleteById(product_owner_id);
    }


}
