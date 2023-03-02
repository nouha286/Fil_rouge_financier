package com.example.financier.Repository;

import com.example.financier.Model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit,Long> {
}
