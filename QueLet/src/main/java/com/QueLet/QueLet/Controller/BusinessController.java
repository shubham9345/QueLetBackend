package com.QueLet.QueLet.Controller;

import com.QueLet.QueLet.Model.Business;
import com.QueLet.QueLet.Model.CategoryType;
import com.QueLet.QueLet.Repository.BusinessRepository;
import com.QueLet.QueLet.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping("/All-business")
    public List<Business> getAllBusiness(){
        return businessService.AllBusiness();
    }
    @GetMapping("/business-category")
    public ResponseEntity<List<Business>> getBusinessesByCategoryType(@RequestParam CategoryType categoryType) {
        List<Business> businesses = businessService.getBusinessType(categoryType);
        return ResponseEntity.ok(businesses);
    }
}
