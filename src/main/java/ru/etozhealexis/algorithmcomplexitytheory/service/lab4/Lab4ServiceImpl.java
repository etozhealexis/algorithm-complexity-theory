package ru.etozhealexis.algorithmcomplexitytheory.service.lab4;

import com.bpodgursky.jbool_expressions.Expression;
import com.bpodgursky.jbool_expressions.parsers.ExprParser;
import com.bpodgursky.jbool_expressions.rules.RuleSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.etozhealexis.algorithmcomplexitytheory.constant.CommonConstant;
import ru.etozhealexis.algorithmcomplexitytheory.constant.Lab4Constant;
import ru.etozhealexis.algorithmcomplexitytheory.dto.Lab4DTO;

import java.util.Collection;
import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@Service
public class Lab4ServiceImpl implements Lab4Service {

    @Override
    public void solveLab4(Lab4DTO request) {
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
        if (formulaIsEqualToCNF && maxTwoDuplicatesOfEachVariable) {
            log.info(String.format(Lab4Constant.SUITABLE_FORMULA_MESSAGE, formulaString));
        } else {
            if (!formulaIsEqualToCNF) {
                log.info(String.format(Lab4Constant.NOT_IN_CNF_MESSAGE, formulaString));
            }
            if (!maxTwoDuplicatesOfEachVariable) {
                log.info(Lab4Constant.TOO_MANY_DUPLICATES_MESSAGE);
            }
        }
        log.info(String.format(Lab4Constant.TIME_EXECUTION_MESSAGE, executionTime));
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
