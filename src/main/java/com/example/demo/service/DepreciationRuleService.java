package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.DepreciationRule;

public interface DepreciationRuleService{
     DepreciationRule createRule(DepreciationRule rule);
     List<DepreciationRule> getAllRules();
}