package com.cw.aoc.d3;

public class DiagnosticReport {
    private final long gammaRate;
    private final long epsilonRate;
    private final long oxygenGeneratorRating;
    private final long co2ScrubberRating;

    public DiagnosticReport(long gammaRate, long epsilonRate) {
        this.gammaRate = gammaRate;
        this.epsilonRate = epsilonRate;
        oxygenGeneratorRating = 0L;
        co2ScrubberRating = 0L;
    }

    public DiagnosticReport(long gammaRate, long epsilonRate, long oxygenGeneratorRating, long co2ScrubberRating) {
        this.gammaRate = gammaRate;
        this.epsilonRate = epsilonRate;
        this.oxygenGeneratorRating = oxygenGeneratorRating;
        this.co2ScrubberRating = co2ScrubberRating;
    }

    public long getGammaRate() {
        return gammaRate;
    }

    public long getEpsilonRate() {
        return epsilonRate;
    }

    public long getPowerConsumption() {
        return gammaRate * epsilonRate;
    }

    public long getOxygenGeneratorRating() {
        return oxygenGeneratorRating;
    }

    public long getCo2ScrubberRating() {
        return co2ScrubberRating;
    }

    public long getLifeSupportRating() {
        return co2ScrubberRating * oxygenGeneratorRating;
    }

    @Override
    public String toString() {
        return "DiagnosticReport{" +
                "gammaRate=" + gammaRate +
                ", epsilonRate=" + epsilonRate +
                '}' + "; power consumption = " + getPowerConsumption()
                + "; life support rating = " + getLifeSupportRating();
    }
}
