package com.example.customm.service;

import com.example.customm.dto.PaymentPlanDto;
import com.example.customm.entity.PaymentPlan;
import com.example.customm.repository.PaymentPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentPlanServiceImpl implements PaymentPlanService{

    @Autowired
    private PaymentPlanRepository paymentPlanRepository;

    @Override
    public PaymentPlan savePlan(PaymentPlanDto paymentPlanDto) {

        PaymentPlan newPlan = new PaymentPlan();
        newPlan.setName(paymentPlanDto.getName());
        newPlan.setDuration(paymentPlanDto.getDuration());
        newPlan.setInterest(paymentPlanDto.getInterest());

        return paymentPlanRepository.save(newPlan);
    }

    @Override
    public List<PaymentPlan> getPlans() {
        return paymentPlanRepository.findAll();
    }

    @Override
    public PaymentPlan getPlan(Long id) {

        Optional<PaymentPlan> paymentPlan = paymentPlanRepository.findById(id);
        return paymentPlan.get();
    }

    @Override
    public void delete(Long id) {
        PaymentPlan paymentPlan = getPlan(id);
        paymentPlanRepository.deleteById(paymentPlan.getId());
    }

    @Override
    public PaymentPlan updatePlan(Long id, PaymentPlanDto paymentPlanDto) {
        PaymentPlan planInDb = paymentPlanRepository.findById(id).get();

        if (Objects.nonNull(paymentPlanDto.getName()) &&
        !"".equalsIgnoreCase(paymentPlanDto.getName())){
            planInDb.setName(paymentPlanDto.getName());
        }

        if (Objects.nonNull(paymentPlanDto.getDuration()) &&
        !"".equalsIgnoreCase(paymentPlanDto.getDuration())){
            planInDb.setDuration(paymentPlanDto.getDuration());
        }

        if (Objects.nonNull(paymentPlanDto.getInterest()) &&
        !"".equalsIgnoreCase(paymentPlanDto.getInterest().toString())){
            planInDb.setInterest(paymentPlanDto.getInterest());
        }

        return paymentPlanRepository.save(planInDb);
    }
}
