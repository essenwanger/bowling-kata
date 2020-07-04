package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static final String VALOR_INVALIDO = "El valor de los pinos es invalido";
	private List<Frame> frames;
	private Frame frameActual;
	private int score;
	
	public Game() {
		score = 0;
		frames = new ArrayList<Frame>();
		frameActual = new Frame();
	}

	public void roll(int pins) throws Exception {
		if(pins>10) {
			throw new Exception(VALOR_INVALIDO);
		}
		if(frameActual.isRollTwoExecute() || frameActual.isStrike()) {
			frameActual = new Frame();
		}
		if(!frameActual.isRollOneExecute()) {
			frames.add(frameActual);
			frameActual.setRollOne(pins);
		}else {
			frameActual.setRollTwo(pins);
		}
	}
	
	public int score() {
		score=0;
		for (int numberFrame = 0; numberFrame < frames.size(); numberFrame++) {
			Frame frame = frames.get(numberFrame);
			score+=frame.totalFrame();
			calculateStrikeExtraPoints(frame, numberFrame);
			calculateSpareExtraPoints(frame, numberFrame);
		}
		return score;
	}

	private void calculateStrikeExtraPoints(Frame frame, int numberFrame) {
		calculateStrikeExtraPoints(frame, numberFrame, 0);
	}
	
	private void calculateStrikeExtraPoints(Frame frame, int numberFrame, int numberStrike) {
		int numberFrameNext = numberFrame + 1;
		if (frame.isStrike() && frames.size()>numberFrameNext && numberStrike!=2) {
			Frame frameNext = frames.get(numberFrameNext);
			score+=frameNext.getRollOne();
			score+=frameNext.getRollTwo();
			calculateStrikeExtraPoints(frameNext, numberFrameNext, numberStrike+1);
		}
	}
	
	private void calculateSpareExtraPoints(Frame frame, int numberFrame) {
		int numberFrameNext = numberFrame + 1;
		if(frame.isSpare() && frames.size()>numberFrameNext) {
			Frame frameNext = frames.get(numberFrameNext);
			score+=frameNext.getRollOne();
		}
	}
	
}
