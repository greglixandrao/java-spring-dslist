package com.greglixandrao.javaspringdslist.repositories;

import com.greglixandrao.javaspringdslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
