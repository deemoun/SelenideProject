package org.deemoun;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileReader;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MathOperationsTest {

    private static JSONArray testOperations;

    @BeforeAll
    public static void setUp() {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/main/java/org/deemoun/math_operations.json");
            Object obj = parser.parse(reader);
            testOperations = (JSONArray) obj;
        } catch (Exception e) {
            // Use a more robust logging method instead of printStackTrace
            // e.g. log.error("Failed to read math_operations.json", e);
        }
    }

    @Test
    public void testOperations() {
        for (Object operationObj : testOperations) {
            JSONObject operation = (JSONObject) operationObj;
            String opType = (String) operation.get("operation");
            JSONArray operandsArray = (JSONArray) operation.get("operands");
            List<Long> operands = operandsArray; // This line may need adjustment based on your JSON parsing library
            double expected = ((Number) operation.get("result")).doubleValue();

            double result = 0;
            switch (opType) {
                case "addition":
                    result = operands.get(0) + operands.get(1);
                    break;
                case "subtraction":
                    result = operands.get(0) - operands.get(1);
                    break;
                case "multiplication":
                    result = operands.get(0) * operands.get(1);
                    break;
                case "division":
                    result = operands.get(0).doubleValue() / operands.get(1);
                    break;
            }

            assertEquals(expected, result, 0.01, "Failed at " + opType + " with operands " + operandsArray.toJSONString());
        }
    }
}