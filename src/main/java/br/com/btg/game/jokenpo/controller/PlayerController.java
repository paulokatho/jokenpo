package br.com.btg.game.jokenpo.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.btg.game.jokenpo.entity.dto.PlayerRequest;
import br.com.btg.game.jokenpo.entity.dto.api.ApiResponse;
import br.com.btg.game.jokenpo.service.impl.PlayerServiceImpl;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

@RestController
@RequestMapping("/player")
@CrossOrigin(origins = "*")
public class PlayerController {

    private PlayerServiceImpl playerService;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> insert(@Valid @RequestBody PlayerRequest playerRequest)
            throws JokenpoException {
        return ResponseEntity.ok(
                new ApiResponse<>(this.playerService.insert(playerRequest)));
    }

    @DeleteMapping(value = "")
    public ResponseEntity<Object> delete(@PathParam("playerName") String playerName) throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.playerService.deleteByName(playerName)));
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getAll() throws JokenpoException {
        return ResponseEntity.ok(new ApiResponse<>(this.playerService.getAll()));
    }
}
