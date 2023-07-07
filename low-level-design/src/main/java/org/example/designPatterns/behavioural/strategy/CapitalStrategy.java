package org.example.designPatterns.behavioural.strategy;

public abstract class CapitalStrategy {

    protected LoanWithoutCapitalCalculation loan;

    protected static final int MILLIS_PER_DAY = 86400000;

    double calcCapital(LoanWithoutCapitalCalculation loan) {
        this.loan = loan;
        return riskAmount() * duration() * RiskFactor.forRiskRating(loan.getRating());
    }

    protected abstract double duration();


    private double calcUnusedRiskAmount() {
        return (loan.getNotional() - loan.getOutstanding()) * loan.getUnusedPercentage();
    }

    protected abstract double riskAmount();

    static class RiskFactor {
        static double forRiskRating(int rating) {
            return 1.0;
        }
    }
}
