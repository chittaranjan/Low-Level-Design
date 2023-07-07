package org.example.designPatterns.behavioural.strategy;

public class RevolverCapitalStrategy extends CapitalStrategy{
    private double calcUnusedPercentage() {
        if (loan.getRating() > 4) return 0.75;
        else return 0.25;
    }
    private double calcUnusedRiskAmount() {
        return (loan.getNotional() - loan.getOutstanding()) * calcUnusedPercentage();
    }

    @Override
    protected double riskAmount() {
        return loan.getOutstanding() + calcUnusedRiskAmount();
    }

    protected double duration() {
        return (
                (loan.getExpiry().getTime() - loan.getStart().getTime()) / MILLIS_PER_DAY)
                / 365;
    }
}
