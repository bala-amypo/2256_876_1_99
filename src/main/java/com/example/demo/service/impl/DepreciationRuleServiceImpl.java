package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import java.time.*;


@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {

    private final DepreciationRuleRepository ruleRepository;

    public DepreciationRuleServiceImpl(DepreciationRuleRepository ruleRepository) {
        this.ruleRepository = ruleRepository;
    }

    @Override
    public DepreciationRule createRule(DepreciationRule rule) {

        if (rule.getUsefulLifeYears() <= 0) {
            throw new IllegalArgumentException("Useful life must be greater than 0");
        }

        if (rule.getSalvageValue() < 0) {
            throw new IllegalArgumentException("Salvage value cannot be negative");
        }

        if (!rule.getMethod().equals("STRAIGHT_LINE") && !rule.getMethod().equals("DECLINING_BALANCE")) {
            throw new IllegalArgumentException("Invalid depreciation method");
        }

        rule.setCreatedAt(LocalDateTime.now());
        return ruleRepository.save(rule);
    }
}
