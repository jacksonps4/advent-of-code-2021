package com.cw.aoc.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A generic interface for Advent of Code solutions.
 *
 * @param <T> The type of the result produced by this solver.
 */
public interface Solver<T> {
    /**
     * Called for every new line from the input data.
     *
     * @param input A line of input data.
     */
    void update(String input);

    /**
     * Called when all of the input has been read and sent to the update() method. This should take the data and
     * calculate the solution.
     *
     * @return The solution.
     */
    T solve();

    /**
     * Helper method to run a solution class against some input data.
     *
     * @param solver   The solver to run.
     * @param filename The classpath relative filename of the input data
     * @param <T>      The type of the solution returned by the solve() method.
     * @return The solution of type T
     * @throws IOException If there was an error reading the input data.
     */
    static <T> T run(Solver<T> solver, String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Runner.class.getClassLoader()
                .getResourceAsStream(filename)))) {
            for (String line; (line = reader.readLine()) != null; ) {
                if (line.trim().length() == 0) {
                    continue;
                }
                solver.update(line);
            }
            T result = solver.solve();
            return result;
        }
    }
}
