/*
 * You can use the following import statements
 * 
 * 
 * 
 * 
 */

// Write your code here
package com.example.player.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.player.model.*;

@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Integer> {

}