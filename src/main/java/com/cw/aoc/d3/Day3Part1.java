package com.cw.aoc.d3;

import com.cw.aoc.common.Solver;

import java.util.LinkedList;
import java.util.List;

public class Day3Part1 implements Solver<DiagnosticReport> {
    final List<Boolean[]> reportData = new LinkedList<>();

    @Override
    public void update(String input) {
        reportData.add(getReportData(input));
    }

    private Boolean[] getReportData(String input) {
        char[] inputData = input.toCharArray();
        List<Boolean> data = new LinkedList<>();
        for (int i = 0; i < inputData.length; i++) {
            switch (inputData[i]) {
                case '0':
                    data.add(false);
                    break;
                case '1':
                    data.add(true);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Invalid input '%s'", inputData[i]));
            }
        }
        return data.toArray(new Boolean[data.size()]);
    }

    @Override
    public DiagnosticReport solve() {
        Integer[] counts = calculateCounts(reportData);

        long gammaRate = calculateGammaRate(counts, reportData.size());
        long epsilonRate = calculateEpsilonRate(counts, reportData.size());

        return new DiagnosticReport(gammaRate, epsilonRate);
    }

    static Integer[] calculateCounts(List<Boolean[]> reportData) {
        // 0 0 1 0 0 => 0 0 1 0 0
        // 1 1 1 1 0 => 1 1 2 1 0
        // 1 0 1 1 0 => 2 1 3 2 0
        // 1 0 1 1 1 => 3 1 4 3 1
        // 1 0 1 0 1 => 4 1 5 3 2
        // 0 1 1 1 1 => 4 2 6 4 3
        // 0 0 1 1 1 => 4 2 7 5 4
        // 1 1 1 0 0 => 5 3 8 5 4
        // 1 0 0 0 0 => 6 3 8 5 4
        // 1 1 0 0 1 => 7 4 8 5 5
        // 0 0 0 1 0 => 7 4 8 6 5
        // 0 1 0 1 0 => 7 5 8 7 5
        // length: 12
        // if x > (12/2), gamma = 10110
        // else epsilon = 01001

        List<Integer> counts = new LinkedList<>();
        for (Boolean[] entry : reportData) {
            for (int i = 0; i < entry.length; i++) {
                if (counts.size() <= i) {
                    counts.add(0);
                }
                if (entry[i]) {
                    counts.set(i, counts.get(i) + 1);
                }
            }
        }
        return counts.toArray(new Integer[counts.size()]);
    }

    static long calculateGammaRate(Integer[] counts, int sz) {
        Boolean[] gammaRateBits = new Boolean[counts.length];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > (sz / 2)) {
                gammaRateBits[i] = true;
            } else {
                gammaRateBits[i] = false;
            }
        }
        return convertBitsToLong(gammaRateBits);
    }

    static long calculateEpsilonRate(Integer[] counts, int sz) {
        Boolean[] epsilonRateBits = new Boolean[counts.length];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] <= (sz / 2)) {
                epsilonRateBits[i] = true;
            } else {
                epsilonRateBits[i] = false;
            }
        }
        return convertBitsToLong(epsilonRateBits);
    }

    static long convertBitsToLong(Boolean[] bits) {
        long result = 0L;
        long mask = 1 << bits.length - 1;
        for (int j = 0; j < bits.length; j++) {
            long value = bits[j] ? 1L : 0L;
            result |= (mask * value);
            mask >>= 1;
        }
        return result;
    }
}
