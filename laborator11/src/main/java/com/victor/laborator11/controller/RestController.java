package com.victor.laborator11.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hello")
public class RestController {
    private final List<Player> playerList = new ArrayList<>();
    @GetMapping
    public List<Player> getPlayerList() {
        return playerList;
    }
    @PostMapping
    public int createPlayer(@RequestParam String name){
        int id=1+playerList.size();
        playerList.add(new Player(id,"Marcel"));
        return id;
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(
            @PathVariable int id, @RequestParam String name){
        Player player=findById(id);
        player.setName(name);
        return new ResponseEntity<>("PLayer Updated", HttpStatus.OK);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id){
        Player player=findById(id);
        player.remove(player);
        return new ResponseEntity<>("Player removed",HttpStatus.OK);
    }


}
