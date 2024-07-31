/*
 * 
 * You can use the following import statemets
 * 
 * 
 * 
 */

// Write your code here
package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.service.*;
import com.example.player.model.*;

/**
 * PlayerController
 */
@RestController
public class PlayerController {
    @Autowired
    private PlayerJpaService playerJpaService;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerJpaService.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayer(@PathVariable("playerId") int playerId) {
        return playerJpaService.getPlayerById(playerId);
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        return playerJpaService.addPlayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return playerJpaService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable int id) {
        playerJpaService.deletePlayer(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}