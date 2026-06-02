package com.devsuperior.evento.repositories;

import com.devsuperior.evento.entities.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlocoRepository extends JpaRepository<Bloco, Integer> {
}
