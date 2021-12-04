package com.cw.aoc.d3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Day3Part2 extends Day3Part1 {
    @Override
    public DiagnosticReport solve() {
        // 0 0 1 0 0
        // 1 1 1 1 0
        // 1 0 1 1 0
        // 1 0 1 1 1
        // 1 0 1 0 1
        // 0 1 1 1 1
        // 0 0 1 1 1
        // 1 1 1 0 0
        // 1 0 0 0 0
        // 1 1 0 0 1
        // 0 0 0 1 0
        // 0 1 0 1 0
        // length: 12

        /*
        10110
        1.
        // 1 1 1 1 0
        // 1 0 1 1 0
        // 1 0 1 1 1
        // 1 0 1 0 1
        // 1 1 1 0 0
        // 1 0 0 0 0
        // 1 1 0 0 1

        2.
        // 1 0 1 1 0
        // 1 0 1 1 1
        // 1 0 1 0 1
        // 1 0 0 0 0

        3.
        // 1 0 1 1 0
        // 1 0 1 1 1
        // 1 0 1 0 1

        4.
        // 1 0 1 1 0
        // 1 0 1 1 1

        5.
        // 1 0 1 1 1
         */

        long oxygenGeneratorRating = calculateOxygenGeneratorRating();
        long co2ScrubberRating = calculateCo2ScrubberRating();

        DiagnosticReport report = super.solve();
        return new DiagnosticReport(report.getGammaRate(), report.getEpsilonRate(), oxygenGeneratorRating, co2ScrubberRating);
    }

    long calculateOxygenGeneratorRating() {
        Integer[] counts = calculateCounts(reportData);
        List<Boolean[]> filteredSelection = new LinkedList<>(reportData);
        int i = 0;
        while (filteredSelection.size() > 1 && i < counts.length) {
            int onesCount = counts[i];
            int zeroesCount = filteredSelection.size() - counts[i];
            for (Iterator<Boolean[]> itr = filteredSelection.iterator(); itr.hasNext(); ) {
                Boolean[] report = itr.next();
                // if there are more 1s than 0s across the whole report
                if (onesCount >= zeroesCount) {
                    if (!report[i]) {
                        itr.remove();
                    }
                } else {
                    if (report[i]) {
                        itr.remove();
                    }
                }
            }
            counts = calculateCounts(filteredSelection);
            i++;
        }

        return convertBitsToLong(filteredSelection.get(0));
    }

    long calculateCo2ScrubberRating() {
        Integer[] counts = calculateCounts(reportData);
        List<Boolean[]> filteredSelection = new LinkedList<>(reportData);
        int i = 0;
        while (filteredSelection.size() > 1 && i < counts.length) {
            int onesCount = counts[i];
            int zeroesCount = filteredSelection.size() - counts[i];
            for (Iterator<Boolean[]> itr = filteredSelection.iterator(); itr.hasNext(); ) {
                Boolean[] report = itr.next();
                if (zeroesCount > onesCount) {
                    if (!report[i]) {
                        itr.remove();
                    }
                } else {
                    if (report[i]) {
                        itr.remove();
                    }
                }
            }
            counts = calculateCounts(filteredSelection);
            i++;
        }

        return convertBitsToLong(filteredSelection.get(0));
    }
}
