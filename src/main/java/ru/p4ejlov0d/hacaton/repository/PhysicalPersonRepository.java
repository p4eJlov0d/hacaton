package ru.p4ejlov0d.hacaton.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.p4ejlov0d.hacaton.entity.PhysicalPerson;

@Repository
public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, String> {
}
