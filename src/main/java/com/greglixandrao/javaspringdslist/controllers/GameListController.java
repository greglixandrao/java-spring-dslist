package com.greglixandrao.javaspringdslist.controllers;

import com.greglixandrao.javaspringdslist.dto.GameListDTO;
import com.greglixandrao.javaspringdslist.dto.GameMinDTO;
import com.greglixandrao.javaspringdslist.dto.ReplacementDTO;
import com.greglixandrao.javaspringdslist.services.GameListService;
import com.greglixandrao.javaspringdslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }
    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }
    @PostMapping(value = "/{listId}/replacement")
    public void moveGame(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.moveGame(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
