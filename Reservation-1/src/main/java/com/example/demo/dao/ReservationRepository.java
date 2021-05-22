package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	@Query("select r from Reservation r where r.event.idevent=:type and r.user.idpers=:login")
	public List<Reservation> findAll(@Param("type")Long type,@Param("login")Long login);

}
