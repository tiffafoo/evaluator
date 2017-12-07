package com.tiffanyln.evaluator;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import com.tiffanyln.exceptions.IllegalInfixFormat;
import com.tiffanyln.interfaces.Queue;
import com.tiffanyln.structures.DynamicArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EvaluatorTest {
    Queue<String> infixExpression;
    double expectedAnswer;

    @Parameters(name = "{index} plan[{0} = {1}]")
    public static Collection<Object[]> data() {
        /* Basic Arithmetic */
        Queue<String> e1 = new DynamicArray<>();
        e1.add("1");
        e1.add("+");
        e1.add("1");
        double a1 = 2;

        Queue<String> e2 = new DynamicArray<>();
        e1.add("2");
        e1.add("-");
        e1.add("1");
        double a2 = 1;

        Queue<String> e3 = new DynamicArray<>();
        e1.add("10");
        e1.add("*");
        e1.add("40");
        double a3 = 400;

        Queue<String> e4 = new DynamicArray<>();
        e1.add("55");
        e1.add("/");
        e1.add("11");
        double a4 = 5;

        /* @todo Multiplication/Division with 0 */

        /* @todo Parenthesis */

        return Arrays.asList(new Object[][] {
                {e1, a1}, {e2, a2},
                {e3, a3}, {e4, a4}
        });
    }

    public EvaluatorTest(Queue<String> infixExpression, double expectedAnswer) {
        this.infixExpression = infixExpression;
        this.expectedAnswer = expectedAnswer;
    }

    @Test
    public void testEvaluate() throws IllegalInfixFormat {
        double result = new Evaluator().evaluate(infixExpression).remove();

        Assert.assertEquals(expectedAnswer, result);
    }
}