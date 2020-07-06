package bowling;

public class Frame {

	private int rollOne;
	private int rollTwo;
	private int rollExtraOne;
	private int rollExtraTwo;
	private boolean rollOneExecute;
	private boolean rollTwoExecute;
	private boolean rollExtraOneExecute;
	private boolean rollExtraTwoExecute;
	
	public Frame() {
		rollOne = 0;
		rollTwo = 0;
		rollExtraOne = 0;
		rollExtraTwo = 0;
		rollOneExecute = false;
		rollTwoExecute = false;
		rollExtraOneExecute = false;
		rollExtraTwoExecute = false;
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

	public int getRollExtraOne() {
		return rollExtraOne;
	}

	public void setRollExtraOne(int rollExtraOne) {
		this.rollExtraOne = rollExtraOne;
		rollExtraOneExecute = true;
	}

	public int getRollExtraTwo() {
		return rollExtraTwo;
	}

	public void setRollExtraTwo(int rollExtraTwo) {
		this.rollExtraTwo = rollExtraTwo;
		rollExtraTwoExecute = true;
	}

	public boolean isRollOneExecute() {
		return rollOneExecute;
	}

	public boolean isRollTwoExecute() {
		return rollTwoExecute;
	}
	
	public boolean isRollExtraOneExecute() {
		return rollExtraOneExecute;
	}

	public boolean isRollExtraTwoExecute() {
		return rollExtraTwoExecute;
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
