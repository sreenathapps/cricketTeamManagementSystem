/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */
package com.example.player.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.player.model.Player;
import com.example.player.service.PlayerH2Service;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class PlayerController {
    @Autowired
    private PlayerH2Service playerH2Service;

    @GetMapping("/players")
    public ArrayList<Player> getPlayers() {
        return playerH2Service.getPlayers();
    }
    
    
}