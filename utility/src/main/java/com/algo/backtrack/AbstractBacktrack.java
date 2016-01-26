package com.algo.backtrack;

public abstract class AbstractBacktrack implements Backtrack<Object> {

	@Override
	public void backtrack(Object[] a, int k, Object input) {
		if (isASolution(a, k, input)) {
			processSolution(a, k, input);
			return;
		}
		Object[] candidate = constructCandidates(a, k, input);
		for (int i = 0; i < candidate.length; i++) {
			if (isValid(candidate)) {
				k = k + 1;
				makeMove(a, k, input);
				backtrack(a, k, input);
				unmakeMove(a, k, input);
			}
		}

	}
	private boolean isValid(Object[] candidate) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Object[] constructCandidates(Object[] a, int k, Object input) {
		return null;
	}
	@Override
	public boolean isASolution(Object[] a, int k, Object input) {
		return false;
	}
	@Override
	public void makeMove(Object[] a, int k, Object input) {

	}
	@Override
	public void processSolution(Object[] a, int k, Object input) {
	}
	@Override
	public void unmakeMove(Object[] a, int k, Object input) {
	}
}
