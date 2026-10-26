package ru.p4ejlov0d.hacaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.p4ejlov0d.hacaton.entity.Company;
import ru.p4ejlov0d.hacaton.entity.Payment;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findAllByBeneficiaryOrPayer(Company beneficiary, Company payer);
}
