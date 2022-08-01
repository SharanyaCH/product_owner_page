package TargetUpcurve.product_owner_page.controller;

import TargetUpcurve.product_owner_page.exception.ResourceNotFoundException;
import TargetUpcurve.product_owner_page.model.ProductOwner;
import TargetUpcurve.product_owner_page.repository.ProductOwnerRepository;
import TargetUpcurve.product_owner_page.service.ProductOwnerService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@Controller//dont give @RestController , bz restcontroller contains responsebody annotation which will return just string not view

//@RequestMapping("/api/v1")
public class ProductOwnerController {
    @Autowired
    private ProductOwnerRepository productOwnerRepository;
    private ProductOwnerService productOwnerService;

    public ProductOwnerController(ProductOwnerService productOwnerService){
        super();
        this.productOwnerService=productOwnerService;
    }

    @PostMapping("/add_product_owners")
    public String createProductOwner(@ModelAttribute("productOwner") ProductOwner productOwner){
        productOwnerService.saveProductOwner(productOwner);
        return "redirect:/product_owners";
    }

    @GetMapping("/product_owners")
    public String getAllProductOwners(Model model){
        model.addAttribute("product_owners",productOwnerService.getAllProductOwners());
        return "product_owners";
    }

    @GetMapping("/product_owners/new")
    public String CreatePOForm(Model model){
        ProductOwner productOwner=new ProductOwner();
        model.addAttribute("productOwner",productOwner);
        return "create_product_owner";
    }

    @GetMapping("/product_owners/update/{product_owner_id}")
    public String editPOForm(@PathVariable Long product_owner_id,Model model){
        model.addAttribute("productOwner",productOwnerService.getProductOwnerById(product_owner_id));
        return "update_productOwner";
    }

    @PostMapping("/update_product_owners/{product_owner_id}")
    public String UpdateProductOwner(@PathVariable Long product_owner_id,@ModelAttribute("productOwner") ProductOwner productOwner,Model model){
        ProductOwner updateproductOwner=productOwnerService.getProductOwnerById(product_owner_id);

        updateproductOwner.setProduct_owner_id(product_owner_id);
        updateproductOwner.setFirstname(productOwner.getFirstname());
        updateproductOwner.setLastname(productOwner.getLastname());
        updateproductOwner.setEmailId(productOwner.getEmailId());
        updateproductOwner.setProduct_Name(productOwner.getProduct_Name());
        updateproductOwner.setProduct_Type(productOwner.getProduct_Type());

        productOwnerService.updateProductOwner(updateproductOwner);
        return "redirect:/product_owners";
    }

    @GetMapping("/product_owners/{product_owner_id}")
    public String deleteProductOwner(@PathVariable long product_owner_id){
        productOwnerService.deletePOById(product_owner_id);
        return "redirect:/product_owners";
    }


    /*@PutMapping("/update/{product_owner_id}")
    public ResponseEntity<ProductOwner> updateProductOwner(@PathVariable long product_owner_id,@RequestBody ProductOwner productOwnerdetails){
        ProductOwner updateproductOwner=productOwnerRepository.findById(product_owner_id)
                .orElseThrow(()->new ResourceNotFoundException("Product owner not exist by the id:"+product_owner_id));
        updateproductOwner.setFirstname(productOwnerdetails.getFirstname());
        updateproductOwner.setLastname(productOwnerdetails.getLastname());
        updateproductOwner.setEmailId(productOwnerdetails.getEmailId());
        updateproductOwner.setProduct_Name(productOwnerdetails.getProduct_Name());
        updateproductOwner.setProduct_Type(productOwnerdetails.getProduct_Type());

        productOwnerRepository.save(updateproductOwner);
        return ResponseEntity.ok(updateproductOwner);
    }

    @DeleteMapping("/delete/{product_owner_id}")
    public String deleteProductOwner(@PathVariable long product_owner_id){
        productOwnerRepository.findById(product_owner_id)
                .orElseThrow(()->new ResourceNotFoundException("Product owner not exist by the id:"+product_owner_id));
        productOwnerRepository.deleteById(product_owner_id);
        return "Deleted Successfully";
    }


    /*@PostMapping("/add_productowners")
    public String createProductOwner(@RequestBody ProductOwner productOwner){
        productOwnerRepository.save(productOwner);
        return "Added Successfully";
        }*/


    /*@GetMapping("/get_all_productowners")
    public List<ProductOwner> getAllProductOwners(){
        return productOwnerRepository.findAll();
    }*/

    /*@GetMapping("/get_by_id/{product_owner_id}")
    public ResponseEntity<ProductOwner> getProductOwnerById(@PathVariable long product_owner_id){
        ProductOwner productOwner=productOwnerRepository.findById(product_owner_id)
                .orElseThrow(()->new ResourceNotFoundException("Product owner not exist by the id:"+product_owner_id));
        return ResponseEntity.ok(productOwner);
    }*/
}
