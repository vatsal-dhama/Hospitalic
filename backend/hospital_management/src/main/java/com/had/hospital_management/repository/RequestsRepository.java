package com.had.hospital_management.repository;

import com.had.hospital_management.model.Appointment;
import com.had.hospital_management.model.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestsRepository extends JpaRepository<Requests , Long> {
    @Query(
            nativeQuery = true,
            value = "select * from requests where report_id = :report_id"
    )
    List<Requests> findRequestsByReportId(@Param("report_id") Long report_id);
    @Modifying
    @Query(
            nativeQuery = true,
            value = "update requests set status = 1 where id = :request_id"
    )
    void approveRequestById(@Param("request_id") Long request_id);
    @Query(
            nativeQuery = true,
            value = "select * from requests where radiologist_id = :radiologist_id and status =1"
    )
    List<Long> getReportIdByRadiologistId(@Param("radiologist_id") Long radiologist_id);
}
