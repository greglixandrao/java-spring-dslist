package com.greglixandrao.javaspringdslist.services;

import com.greglixandrao.javaspringdslist.dto.GameListDTO;
import com.greglixandrao.javaspringdslist.entities.GameList;
import com.greglixandrao.javaspringdslist.projections.GameMinProjection;
import com.greglixandrao.javaspringdslist.repositories.GameListRepository;
import com.greglixandrao.javaspringdslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> resultado = gameListRepository.findAll();
        return resultado.stream().map(x -> new GameListDTO(x)).toList();
    }
    @Transactional
    public void moveGame(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(), i);
        }
    }

}
