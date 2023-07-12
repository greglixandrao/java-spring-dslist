package com.greglixandrao.javaspringdslist.repositories;

import com.greglixandrao.javaspringdslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
