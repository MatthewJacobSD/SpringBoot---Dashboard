package org.hospital.dashboard.repository;

import org.hospital.dashboard.models.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, String> {
    //
}
