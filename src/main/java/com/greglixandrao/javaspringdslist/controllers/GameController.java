package com.greglixandrao.javaspringdslist.controllers;

import com.greglixandrao.javaspringdslist.dto.GameMinDTO;
import com.greglixandrao.javaspringdslist.entities.Game;
import com.greglixandrao.javaspringdslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;
    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }
}