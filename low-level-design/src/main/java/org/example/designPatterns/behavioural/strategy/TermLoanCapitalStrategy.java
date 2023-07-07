package org.example.designPatterns.behavioural.strategy;

public class TermLoanCapitalStrategy extends CapitalStrategy {

    @Override
    protected double duration() {
        return (
                (loan.getMaturity().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY)
                / 365;
    }

    @Override
    protected double riskAmount() {
        return loan.getOutstanding();
    }

}
