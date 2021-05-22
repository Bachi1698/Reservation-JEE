package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Billet;

public interface BilletReposirory extends JpaRepository<Billet, Long> {

}
