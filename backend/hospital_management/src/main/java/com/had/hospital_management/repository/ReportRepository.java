package com.had.hospital_management.repository;
import com.had.hospital_management.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReportRepository extends JpaRepository<Report,Long>{
}
