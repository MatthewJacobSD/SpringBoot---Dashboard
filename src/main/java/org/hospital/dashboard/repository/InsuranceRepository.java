package org.hospital.dashboard.repository;

import org.hospital.dashboard.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, String> {
    //
}
