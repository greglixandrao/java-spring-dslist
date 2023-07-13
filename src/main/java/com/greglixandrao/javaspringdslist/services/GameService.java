package com.greglixandrao.javaspringdslist.services;

import com.greglixandrao.javaspringdslist.dto.GameDTO;
import com.greglixandrao.javaspringdslist.dto.GameMinDTO;
import com.greglixandrao.javaspringdslist.entities.Game;
import com.greglixandrao.javaspringdslist.projections.GameMinProjection;
import com.greglixandrao.javaspringdslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> resultado = gameRepository.findAll();
        return resultado.stream().map(x -> new GameMinDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
