package ru.etozhealexis.algorithmcomplexitytheory.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.etozhealexis.algorithmcomplexitytheory.constant.LabEndpoint;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;
import ru.etozhealexis.algorithmcomplexitytheory.service.lab6.Lab6Service;

import java.util.InputMismatchException;

@RestController
@RequiredArgsConstructor
@RequestMapping(LabEndpoint.LAB_6)
public class Lab6Controller {

    private final Lab6Service lab6Service;

    @GetMapping(LabEndpoint.BOARD)
    public ResponseEntity<Lab6BoardDTO> getBoard() {
        return ResponseEntity.ok(lab6Service.getBoard());
    }

    @PostMapping(LabEndpoint.TURN)
    public ResponseEntity<Lab6BoardDTO> makeTurn(@RequestBody Lab6DTO lab6DTO) {
        try {
            return ResponseEntity.ok(lab6Service.makeTurn(lab6DTO));
        } catch (InputMismatchException numberFormatException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(lab6Service.getBoard());
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(lab6Service.getBoard());
        }
    }

    @GetMapping(LabEndpoint.CHECK_GAME_END)
    public boolean checkGameEnd() {
        return lab6Service.checkGameEnd();
    }

    @PostMapping(LabEndpoint.CLEAR)
    public void clearBoard() {
        lab6Service.clearBoard();
    }
}
