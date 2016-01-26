package com.algo.backtrack;

public interface Backtrack<T> {
	void backtrack(Object[] a, int k, T input);
	boolean isASolution(Object[] a, int k, T input);
	void processSolution(Object[] a, int k, T input);
	Object[] constructCandidates(Object[] a, int k, T input);
	void makeMove(Object[] a, int k, T input);
	void unmakeMove(Object[] a, int k, T input);
}
