package logic;

import java.util.Arrays;

public class RiverScoreCollector {
	
	private static final double[] endLoop = new double[] { -1.0, -1.0};
	private double[] left;
	private int score;
	private double[] right;
	
	public RiverScoreCollector(double[] left, int score, double[] right) {
		this.left = left;
		this.score = score;
		this.right = right;
	}

	public void addScore() {
		score += 1;
	}
	
	public boolean isLoop() {
		return 	(Arrays.equals(left, endLoop) &&
				Arrays.equals(right, endLoop)) ||
				Arrays.equals(left, right);
	}
	
	public static double[] getEndloop() {
		return endLoop;
	}

	public double[] getLeft() {
		return left;
	}

	public void setLeft(double[] left) {
		this.left = left;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public double[] getRight() {
		return right;
	}

	public void setRight(double[] right) {
		this.right = right;
	}
	
}
