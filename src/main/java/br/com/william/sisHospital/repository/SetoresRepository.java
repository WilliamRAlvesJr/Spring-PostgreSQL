package br.com.william.sisHospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.william.sisHospital.model.Setores;

@Repository
public interface SetoresRepository extends JpaRepository<Setores, Long> {} 