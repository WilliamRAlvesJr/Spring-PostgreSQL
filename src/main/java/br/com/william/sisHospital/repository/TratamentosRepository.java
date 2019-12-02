package br.com.william.sisHospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.william.sisHospital.model.Tratamentos;

@Repository
public interface TratamentosRepository extends JpaRepository<Tratamentos, Long> {} 