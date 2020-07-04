package bowling;

public class Frame {

	private int rollOne;
	private int rollTwo;
	private boolean rollOneExecute;
	private boolean rollTwoExecute;
	
	public Frame() {
		rollOne = 0;
		rollTwo = 0;
		rollOneExecute = false;
		rollTwoExecute = false;
	}

	public int getRollOne() {
		return rollOne;
	}

	public void setRollOne(int rollOne) {
		this.rollOne = rollOne;
		rollOneExecute = true;
	}

	public int getRollTwo() {
		return rollTwo;
	}

	public void setRollTwo(int rollTwo) {
		this.rollTwo = rollTwo;
		rollTwoExecute = true;
	}

	public boolean isRollOneExecute() {
		return rollOneExecute;
	}

	public boolean isRollTwoExecute() {
		return rollTwoExecute;
	}

	public boolean isStrike() {
		return rollOne==10;
	}
	
	public boolean isSpare() {
		return (rollOne + rollTwo)==10 && rollOne!=10;
	}
	
	public int totalFrame() {
		return rollOne + rollTwo;
	}
	
}
