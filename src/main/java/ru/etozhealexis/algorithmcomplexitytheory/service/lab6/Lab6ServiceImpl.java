package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6BoardDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab6DTO;

import java.util.InputMismatchException;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab6ServiceImpl implements Lab6Service {
    private String[] board;
    private int turnCount = 0;

    @Override
    public Lab6BoardDTO getBoard() {
        if (board == null) {
            board = new String[11];
            for (int i = 0; i < 11; i++) {
                board[i] = String.valueOf(i + 1);
            }
            board[0] = "X";
        }
        log.info(boardToString());
        return Lab6BoardDTO.builder()
                .board(board)
                .build();
    }

    @Override
    public Lab6BoardDTO makeTurn(Lab6DTO lab6DTO) {
        int fieldIndex = checkInputAndGetIfCorrect(lab6DTO);
        checkFieldEmptiness(fieldIndex);
        board[fieldIndex - 1] = "O";
        triggerComputerTurn(fieldIndex);
        log.info(boardToString());
        return Lab6BoardDTO.builder()
                .board(board)
                .build();
    }

    @Override
    public void clearBoard() {
        board = null;
        turnCount = 0;
    }

    @Override
    public boolean checkGameEnd() {
        for (int a = 0; a < 4; a++) {
            String line = switch (a) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[10] + board[0] + board[1];
                case 2 -> board[0] + board[4] + board[8];
                case 3 -> board[9] + board[0] + board[4];
                default -> "";
            };
            if (line.equals("XXX")) {
                return true;
            }
        }
        return false;
    }

    private int checkInputAndGetIfCorrect(Lab6DTO lab6DTO) {
        int fieldIndex;
        try {
            fieldIndex = Integer.parseInt(lab6DTO.getRequest());
        } catch (NumberFormatException ex) {
            String msg = "Incorrect input. Use integer values only";
            log.error(msg);
            throw new InputMismatchException(msg);
        }
        return fieldIndex;
    }

    private void checkFieldEmptiness(int fieldIndex) {
        if (!board[fieldIndex - 1].equals(String.valueOf(fieldIndex))) {
            String msg = "Field already taken";
            log.error(msg);
            throw new IllegalStateException(msg);
        }
    }

    private void triggerComputerTurn(int playerFieldIndex) {
        switch (turnCount) {
            case 0:
                if ((playerFieldIndex == 5) || (playerFieldIndex == 9) || (playerFieldIndex == 10)) {
                    board[1] = "X";
                } else {
                    board[4] = "X";
                }
                turnCount++;
                break;
            case 1:
                if ((board[1].equals("X")) && (!board[2].equals("O"))) {
                    board[2] = "X";
                } else if ((board[1].equals("X")) && (!board[10].equals("O"))) {
                    board[10] = "X";
                }
                if ((board[4].equals("X")) && (!board[8].equals("O"))) {
                    board[8] = "X";
                } else if ((board[4].equals("X")) && (!board[9].equals("O"))) {
                    board[9] = "X";
                }
                turnCount++;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    private String boardToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n")
                .append(board[9].equals("10") ? "|----|" : "|---|").append("\n")
                .append("| ").append(board[9]).append(" |").append("\n")
                .append(board[10].equals("11") ? "|----|---|---|---|" : "|---|---|---|---|").append("\n")
                .append("| ").append(board[10]).append(" | ").append(board[0]).append(" | ").append(board[1]).append(" | ").append(board[2]).append(" |").append("\n")
                .append(board[10].equals("11") ? "|----|---|---|---|" : "|---|---|---|---|").append("\n")
                .append(board[10].equals("11") ? "     | " : "    | ").append(board[3]).append(" | ").append(board[4]).append(" | ").append(board[5]).append(" |").append("\n")
                .append(board[10].equals("11") ? "     |---|---|---|" : "    |---|---|---|").append("\n")
                .append(board[10].equals("11") ? "     | " : "    | ").append(board[6]).append(" | ").append(board[7]).append(" | ").append(board[8]).append(" |").append("\n")
                .append(board[10].equals("11") ? "     |---|---|---|" : "    |---|---|---|").append("\n");
        return sb.toString();
    }
}
