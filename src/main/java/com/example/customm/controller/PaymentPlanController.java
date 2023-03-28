package com.example.customm.controller;

import com.example.customm.dto.PaymentPlanDto;
import com.example.customm.entity.PaymentPlan;
import com.example.customm.service.PaymentPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/paymentPlans")
public class PaymentPlanController {

    @Autowired
    private PaymentPlanService paymentPlanService;

    @PostMapping("/save")
    public ResponseEntity<PaymentPlan> savePlan(@RequestBody PaymentPlanDto paymentPlanDto){
        PaymentPlan paymentPlan = paymentPlanService.savePlan(paymentPlanDto);
        return new ResponseEntity<>(paymentPlan, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentPlan>> getPlans(){
        List<PaymentPlan> paymentPlans = paymentPlanService.getPlans();
        return new ResponseEntity<>(paymentPlans, HttpStatus.OK);
    }

    @GetMapping("/plan/{id}")
    public ResponseEntity<PaymentPlan> getPlan(@PathVariable("id") Long id){
        PaymentPlan paymentPlan = paymentPlanService.getPlan(id);
        return new ResponseEntity<>(paymentPlan, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deletePlan(@PathVariable("id") Long id){
        paymentPlanService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
