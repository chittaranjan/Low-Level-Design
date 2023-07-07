package org.example.designPatterns.behavioural.strategy;

import java.util.Date;

/**
 * Loan class violating SRP
 * We can move the calcCapital() method to a separate class and pass the Loan object to it.
 * This way we can separate the logic of calculating capital from the Loan class.
 * This is called Strategy Pattern.
 *
 */
public class Loan {
    private double notional;
    private double outstanding;
    private int rating;
    private double unusedPercentage;
    private Date start;
    private Date expiry;
    private Date maturity;
    private static final int MILLIS_PER_DAY = 86400000;

    public Loan(double notional, double outstanding, int rating, double unusedPercentage, Date start, Date expiry, Date maturity) {
        this.notional = notional;
        this.outstanding = outstanding;
        this.rating = rating;
        this.unusedPercentage = unusedPercentage;
        this.start = start;
        this.expiry = expiry;
        this.maturity = maturity;
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

    public double calcCapital() {
        return riskAmount() * duration() * RiskFactor.forRiskRating(rating);
    }

    private double riskAmount() {
        if (unusedPercentage != 1.00)
            return outstanding + calcUnusedRiskAmount();
        else
            return outstanding;
    }

    private double calcUnusedRiskAmount() {
        return (notional - outstanding) * unusedPercentage;
    }

    private double duration() {
        if (expiry == null)
            return ((maturity.getTime() - start.getTime()) / MILLIS_PER_DAY) / 365;
        else if (maturity == null)
            return ((expiry.getTime() - start.getTime()) / MILLIS_PER_DAY) / 365;
        else {
            long millisToExpiry = expiry.getTime() - start.getTime();
            long millisFromExpiryToMaturity = maturity.getTime() - expiry.getTime();
            double revolverDuration = (millisToExpiry / MILLIS_PER_DAY) / 365;
            double termDuration = (millisFromExpiryToMaturity / MILLIS_PER_DAY) / 365;
            return revolverDuration + termDuration;
        }
    }

    static class RiskFactor {
        static double forRiskRating(int rating) {
            return 1.0;
        }
    }
}
