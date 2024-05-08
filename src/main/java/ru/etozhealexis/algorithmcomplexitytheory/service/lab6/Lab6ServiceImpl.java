package ru.etozhealexis.algorithmcomplexitytheory.service.lab6;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab6Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab6.BoardDTO;

import java.util.InputMismatchException;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab6ServiceImpl implements Lab6Service {
    private String[] board;
    private int turnCount = 0;

    @Override
    public BoardDTO getBoard() {
        if (board == null) {
            board = new String[Lab6Constant.FIELD_SIZE];
            for (int i = 0; i < Lab6Constant.FIELD_SIZE; i++) {
                board[i] = String.valueOf(i + 1);
            }
            board[0] = Lab6Constant.CROSS;
        }
        log.info(boardToString());
        return BoardDTO.builder()
                .board(board)
                .build();
    }

    @Override
    public BoardDTO makeTurn(LabInputDTO lab6DTO) {
        int fieldIndex = checkInputAndGetIfCorrect(lab6DTO);
        checkFieldEmptiness(fieldIndex);
        board[fieldIndex - 1] = Lab6Constant.NOUGHT;
        triggerComputerTurn(fieldIndex);
        log.info(boardToString());
        return BoardDTO.builder()
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
        for (int i = 0; i < Lab6Constant.POSSIBLE_WINS_COUNT; i++) {
            String line = switch (i) {
                case 0 -> board[0] + board[1] + board[2];
                case 1 -> board[10] + board[0] + board[1];
                case 2 -> board[0] + board[4] + board[8];
                case 3 -> board[9] + board[0] + board[4];
                default -> CommonConstant.VOID;
            };

            if (line.equals(Lab6Constant.CROSS + Lab6Constant.CROSS + Lab6Constant.CROSS)) {
                return true;
            }
        }
        return false;
    }

    private int checkInputAndGetIfCorrect(LabInputDTO lab6DTO) {
        int fieldIndex;
        try {
            fieldIndex = Integer.parseInt(lab6DTO.getRequest());
        } catch (NumberFormatException ex) {
            throw new InputMismatchException(Lab6Constant.INCORRECT_INPUT_MESSAGE);
        }
        return fieldIndex;
    }

    private void checkFieldEmptiness(int fieldIndex) {
        if (!board[fieldIndex - 1].equals(String.valueOf(fieldIndex))) {
            throw new IllegalStateException(Lab6Constant.FIELD_IS_TAKEN_MESSAGE);
        }
    }

    private void triggerComputerTurn(int playerFieldIndex) {
        switch (turnCount) {
            case 0:
                if ((playerFieldIndex == 5) || (playerFieldIndex == 9) || (playerFieldIndex == 10)) {
                    board[1] = Lab6Constant.CROSS;
                } else {
                    board[4] = Lab6Constant.CROSS;
                }
                turnCount++;
                break;
            case 1:
                if ((board[1].equals(Lab6Constant.CROSS)) && (!board[2].equals(Lab6Constant.NOUGHT))) {
                    board[2] = Lab6Constant.CROSS;
                } else if ((board[1].equals(Lab6Constant.CROSS)) && (!board[10].equals(Lab6Constant.NOUGHT))) {
                    board[10] = Lab6Constant.CROSS;
                }
                if ((board[4].equals(Lab6Constant.CROSS)) && (!board[8].equals(Lab6Constant.NOUGHT))) {
                    board[8] = Lab6Constant.CROSS;
                } else if ((board[4].equals(Lab6Constant.CROSS)) && (!board[9].equals(Lab6Constant.NOUGHT))) {
                    board[9] = Lab6Constant.CROSS;
                }
                turnCount++;
                break;
            default:
                throw new IllegalStateException();
        }
    }

    /**
     * Магические константы оставил из-за лени, это же жопа
     */
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
