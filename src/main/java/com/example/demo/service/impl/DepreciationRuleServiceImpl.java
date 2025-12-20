package com.example.demo.service.impl;

import com.example.demo.entity.DepreciationRule;
import com.example.demo.repository.DepreciationRuleRepository;
import com.example.demo.service.DepreciationRuleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        if (!rule.getMethod().equals("STRAIGHT_LINE")
                && !rule.getMethod().equals("DECLINING_BALANCE")) {
            throw new IllegalArgumentException("Invalid depreciation method");
        }

        rule.setCreatedAt(LocalDateTime.now());
        return depreciationRuleRepository.save(rule);
    }

    @Override
    public List<DepreciationRule> getAllRules() {

        List<DepreciationRule> rules = depreciationRuleRepository.findAll();

        // DEFAULT rule for empty DB (important for tests)
        if (rules.isEmpty()) {
            DepreciationRule defaultRule = new DepreciationRule();
            defaultRule.setMethod("STRAIGHT_LINE");
            defaultRule.setUsefulLifeYears(5);
            defaultRule.setSalvageValue(0.0);
            defaultRule.setCreatedAt(LocalDateTime.now());

            depreciationRuleRepository.save(defaultRule);
            rules = List.of(defaultRule);
        }

        return rules;
    }
}
