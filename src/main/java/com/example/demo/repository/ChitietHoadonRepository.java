package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CtHoadon;
import com.example.demo.entity.CtTrangthai;

public interface ChitietHoadonRepository extends JpaRepository<CtHoadon, Integer>{
	@Query(value = "CALL getCT_Hoadon(:MAHD);", nativeQuery = true)
    public List<CtHoadon> getCT_Hoadon(@Param("MAHD") Integer mahd);
	@Query(value = "CALL checkMH_HD(:MAMH);", nativeQuery = true)
    public List<CtHoadon> checkHD_MH(@Param("MAMH") Integer mamh);
}
