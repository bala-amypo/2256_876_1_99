package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;

import org.springframework.stereotype.Service;

import java.time.*;
import java.util.*;

@Service
public class DepreciationRuleServiceImpl implements DepreciationRuleService {

    private final DepreciationRuleRepository depreciationRuleRepository;

    public DepreciationRuleServiceImpl(DepreciationRuleRepository depreciationRuleRepository) {
        this.depreciationRuleRepository = depreciationRuleRepository;
    }

    @Override
    public DepreciationRule createRule(DepreciationRule rule) {

        if (rule.getUsefulLifeYears() <= 0) {
            throw new IllegalArgumentException("usefulLifeYears must be > 0");
        }

        if (rule.getSalvageValue() < 0) {
            throw new IllegalArgumentException("salvageValue must be >= 0");
        }

        if (!rule.getMethod().equals("STRAIGHT_LINE") &&!rule.getMethod().equals("DECLINING_BALANCE")) {
            throw new IllegalArgumentException("Invalid depreciation method");
        }

        rule.setCreatedAt(LocalDateTime.now());
        return depreciationRuleRepository.save(rule);
    }

    @Override
    public List<DepreciationRule> getAllRules() {
        return depreciationRuleRepository.findAll();
    }
}
