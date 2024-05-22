package ru.etozhealexis.algorithmcomplexitytheory.service.lab4;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab4Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.LabInputDTO;
import ru.etozhealexis.algorithmcomplexitytheory.dto.lab4.OutputDTO;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab4ServiceImpl implements Lab4Service {

    @Override
    public OutputDTO solveLab4(LabInputDTO request) {
        String formulaString = request.getRequest();

        long executionStart = System.currentTimeMillis();

        String formulaVariablesWithDuplicates = formulaString.replaceAll(Lab4Constant.REPLACE_PATTERN, CommonConstant.VOID);
        HashMap<Character, Integer> variableToCount = new HashMap<>();
        fillVariableToCount(formulaVariablesWithDuplicates, variableToCount);
        Expression<String> formula = ExprParser.parse(formulaString);
        Expression<String> cnf = RuleSet.toCNF(formula);

        long executionTime = System.currentTimeMillis() - executionStart;

        boolean formulaIsEqualToCNF = formula.toString().equals(cnf.toString());
        boolean maxTwoDuplicatesOfEachVariable = maxTwoDuplicatesOfEachVariable(variableToCount.values());
        String message = "";
        if (formulaIsEqualToCNF && maxTwoDuplicatesOfEachVariable) {
            message = String.format(Lab4Constant.SUITABLE_FORMULA_MESSAGE, formulaString);
            log.info(message);
        } else {
            if (!formulaIsEqualToCNF) {
                message = String.format(Lab4Constant.NOT_IN_CNF_MESSAGE, formulaString);
                log.error(message);
            }
            if (!maxTwoDuplicatesOfEachVariable) {
                message = Lab4Constant.TOO_MANY_DUPLICATES_MESSAGE;
                log.error(message);
            }
        }

        String feasibilityMessage = checkFeasibility(variableToCount, formula);
        log.info(feasibilityMessage);

        String timeExecutionMessage = String.format(CommonConstant.TIME_EXECUTION_MESSAGE, executionTime);
        log.info(timeExecutionMessage);

        return OutputDTO.builder()
                .message(message)
                .timeExecutionMessage(timeExecutionMessage)
                .feasibilityMessage(feasibilityMessage)
                .build();
    }

    private String checkFeasibility(HashMap<Character, Integer> variableToCount, Expression<String> formula) {
        Set<Character> formulaVariables = variableToCount.keySet();
        int formulaVariablesSize = formulaVariables.size();

        for (int i = 0; i < Math.pow(2, formulaVariablesSize); i++) {
            String number = Integer.toBinaryString(i);
            int num = Integer.parseInt(number);
            Map<String, Boolean> variableAssignmentMap = new LinkedHashMap<>();
            for (Character variable : formulaVariables) {
                variableAssignmentMap.put(String.valueOf(variable), num % 10 != 0);
                num /= 10;
            }
            Expression<String> resolved = RuleSet.assign(formula, variableAssignmentMap);
            if (Boolean.parseBoolean(resolved.toString())) {
                return Lab4Constant.IS_FEASIBLE_MESSAGE;
            }
        }
        return Lab4Constant.NOT_FEASIBLE_MESSAGE;
    }

    private void fillVariableToCount(String formulaVariablesWithDuplicates, HashMap<Character, Integer> variableToCount) {
        for (int i = 0; i < formulaVariablesWithDuplicates.length(); i++) {
            char variable = formulaVariablesWithDuplicates.charAt(i);
            if (variableToCount.containsKey(variable)) {
                variableToCount.put(variable, variableToCount.get(variable) + Lab4Constant.ONE);
            }  else {
                variableToCount.put(variable, Lab4Constant.ONE);
            }
        }
    }

    private boolean maxTwoDuplicatesOfEachVariable(Collection<Integer> values) {
        for (int value : values) {
            if (value > Lab4Constant.MAX_DUPLICATES) {
                return false;
            }
        }
        return true;
    }
}
