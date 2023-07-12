package com.greglixandrao.javaspringdslist.services;

import com.greglixandrao.javaspringdslist.dto.GameListDTO;
import com.greglixandrao.javaspringdslist.entities.GameList;
import com.greglixandrao.javaspringdslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepositoryRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultado = gameListRepositoryRepository.findAll();
        return resultado.stream().map(x -> new GameListDTO(x)).toList();
    }

}
