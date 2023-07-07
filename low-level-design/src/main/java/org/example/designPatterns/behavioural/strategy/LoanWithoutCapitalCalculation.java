package org.example.designPatterns.behavioural.strategy;

import java.util.Date;

public class LoanWithoutCapitalCalculation {
    private double notional;
    private double outstanding;
    private int rating;
    private double unusedPercentage;
    private Date start;
    private Date expiry;
    private Date maturity;

    private CapitalStrategy capitalStrategy;
    private static final int MILLIS_PER_DAY = 86400000;

    public LoanWithoutCapitalCalculation(double notional, double outstanding, int rating, double unusedPercentage,
                                         Date start, Date expiry, Date maturity, CapitalStrategy capitalStrategy) {
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.unusedPercentage = unusedPercentage;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
        this.capitalStrategy = capitalStrategy;
    }

    public double getNotional() {
        return notional;
    }

    public double getOutstanding() {
        return outstanding;
    }

    public int getRating() {
        return rating;
    }

    public double getUnusedPercentage() {
        return unusedPercentage;
    }

    public Date getStart() {
        return start;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }

    public static LoanWithoutCapitalCalculation newTermLoan(double notional, double outstanding, int rating,
                                                            double unusedPercentage, Date start, Date expiry, Date maturity, CapitalStrategy strategy) {
        return new LoanWithoutCapitalCalculation(notional, outstanding, rating, unusedPercentage, start, expiry, maturity, strategy);
    }


    public double calcCapital() {
        return this.capitalStrategy.calcCapital(this);
    }
}
