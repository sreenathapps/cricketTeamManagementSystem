/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.player.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.player.model.*;
import com.example.player.repository.*;

@Service
public class PlayerJpaService implements PlayerRepository {

	@Autowired
	private PlayerJpaRepository playerJpaRepository;

	@Override
	public ArrayList<Player> getPlayers() {
		List<Player> playerList = playerJpaRepository.findAll();
		return new ArrayList<>(playerList);
	}

	@Override
	public Player addPlayer(Player player) {
		playerJpaRepository.save(player);
		return player;
	}

	@Override
	public Player getPlayerById(int playerId) {
		try {
			Player player = playerJpaRepository.findById(playerId).get();
			return player;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Player updatePlayer(int playerId, Player player) {
		try {
			Player newPlayer = playerJpaRepository.findById(playerId).get();
			if (player.getPlayerName() != null) {
				newPlayer.setPlayerName(player.getPlayerName());
			}
			if (player.getJerseyNumber() != 0) {
				newPlayer.setJerseyNumber(player.getJerseyNumber());
			}
			if (player.getRole() != null) {
				newPlayer.setRole(player.getRole());
			}
			playerJpaRepository.save(newPlayer);
			return newPlayer;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deletePlayer(int playerId) {
		try {
			playerJpaRepository.deleteById(playerId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}