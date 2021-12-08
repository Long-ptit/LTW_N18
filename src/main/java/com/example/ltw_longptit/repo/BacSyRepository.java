package com.example.ltw_longptit.repo;

import com.example.ltw_longptit.model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BacSyRepository extends JpaRepository<BacSi, Integer> {
    @Query(value = "SELECT * from bac_si where bacsy_ten like %:keyword%" , nativeQuery = true)
    public List<BacSi> searchBacSy(@Param("keyword") String keyword);

}
