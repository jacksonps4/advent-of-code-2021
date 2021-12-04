package com.cw.aoc.common;

public class Runner {
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        if (filename == null || filename.trim().length() == 0) {
            throw new IllegalArgumentException("Must specify filename as argument");
        }

        String solverClass = args[1];
        if (solverClass == null || solverClass.trim().length() == 0) {
            throw new IllegalArgumentException("Must specify solver class as argument");
        }

        Solver solver = (Solver) Class.forName(solverClass).getConstructor().newInstance();
        Object result = Solver.run(solver, filename);
        System.out.printf("%s", result);
    }
}
