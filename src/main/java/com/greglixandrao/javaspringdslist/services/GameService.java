package com.greglixandrao.javaspringdslist.services;

import com.greglixandrao.javaspringdslist.dto.GameMinDTO;
import com.greglixandrao.javaspringdslist.entities.Game;
import com.greglixandrao.javaspringdslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){
        List<Game> resultado = gameRepository.findAll();
        return resultado.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
