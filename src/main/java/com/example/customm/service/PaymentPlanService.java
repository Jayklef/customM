package com.example.customm.service;

import com.example.customm.dto.PaymentPlanDto;
import com.example.customm.entity.PaymentPlan;

import java.util.List;

public interface PaymentPlanService {
    PaymentPlan savePlan(PaymentPlanDto paymentPlanDto);

    List<PaymentPlan> getPlans();

    PaymentPlan getPlan(Long id);

    void delete(Long id);
}
