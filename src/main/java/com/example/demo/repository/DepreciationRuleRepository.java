package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.example.demo.entity.DepreciationRule;

@Repository
public interface DepreciationRuleRepository extends JpaRepository<DepreciationRule,Long>{
    Optional<DepreciationRule> findByRuleName(String ruleName);
}