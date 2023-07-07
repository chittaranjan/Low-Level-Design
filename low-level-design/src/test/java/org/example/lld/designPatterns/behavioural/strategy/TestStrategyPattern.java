package org.example.lld.designPatterns.behavioural.strategy;

import org.example.designPatterns.behavioural.strategy.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestStrategyPattern {


    @BeforeEach
    public void init() {

    }

    @Test
    public void testTestWithoutStrategy() {
        //Get a Loan object with a valid start and expiry date
        Loan loan = new Loan(1000, 100, 1,
                0.1, new Date(2020, 1, 1), new Date(2021, 1, 1), null);
        System.out.println(loan.calcCapital());
        Assertions.assertEquals(190.0, loan.calcCapital());
    }

    @Test
    public void testTestWithTermLoanCapitalStrategy() {
        CapitalStrategy strategy = new TermLoanCapitalStrategy();
        //Get a Loan object with a valid start , expiry date and maturity date
        LoanWithoutCapitalCalculation loan = new LoanWithoutCapitalCalculation(1000, 100, 1,
                0.1, new Date(2020, 1, 1), new Date(2021, 1, 1), new Date(2022, 1, 1), strategy);

        //Assert capital
        Assertions.assertEquals(200, loan.calcCapital());
    }

    @Test
    public void testTestWithRevolverCapitalStrategy() {
        CapitalStrategy strategy = new RevolverCapitalStrategy();
        //Get a Loan object with a valid start , expiry date and maturity date
        LoanWithoutCapitalCalculation loan = new LoanWithoutCapitalCalculation(1000, 100, 1,
                0.1, new Date(2020, 1, 1), new Date(2021, 1, 1), new Date(2022, 1, 1), strategy);
        //Assert capital
        Assertions.assertEquals(325.0, loan.calcCapital());
    }
}
