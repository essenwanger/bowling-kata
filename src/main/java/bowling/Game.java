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
		
		if(frames.size()==10 && frameActual.isSpare()) {
			frameActual.setRollExtraOne(pins);
		}else if(frames.size()==10 && frameActual.isStrike() && !frameActual.isRollExtraOneExecute()) {
			frameActual.setRollExtraOne(pins);
		}else if(frames.size()==10 && frameActual.isStrike() && frameActual.isRollExtraOneExecute()) {
			frameActual.setRollExtraTwo(pins);
		}else {
			rollRegularFrame(pins);
		}
		
	}

	private void rollRegularFrame(int pins) {
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
			calculateSpareExtraPoints(frame, numberFrame);
			calculateStrikeExtraPoints(frame, numberFrame);
		}
		return score;
	}

	private void calculateStrikeExtraPoints(Frame frame, int numberFrame) {
		int numberFrameNext = numberFrame + 1;
		if (frame.isStrike() && existFrame(numberFrameNext)) {
			Frame frameNext = frames.get(numberFrameNext);
			score+=frameNext.getRollOne();
			int numberFrameNextNext = numberFrameNext + 1;
			if(frameNext.isStrike() &&  existFrame(numberFrameNextNext)) {
				Frame frameNextNext = frames.get(numberFrameNextNext);
				score+=frameNextNext.getRollOne();
			}else if(frameNext.isStrike() &&  lastFrame(numberFrameNext)) {
				score+=frameNext.getRollExtraOne();
			}else {
				score+=frameNext.getRollTwo();
			}
		}else if(frame.isStrike() && lastFrame(numberFrame)) {
			score+=frame.getRollExtraOne();
			score+=frame.getRollExtraTwo();
		}
	}
	
	private void calculateSpareExtraPoints(Frame frame, int numberFrame) {
		int numberFrameNext = numberFrame + 1;
		if(frame.isSpare() && existFrame(numberFrameNext)) {
			Frame frameNext = frames.get(numberFrameNext);
			score+=frameNext.getRollOne();
		}else if(frame.isSpare() && lastFrame(numberFrame)) {
			score+=frame.getRollExtraOne();
		}
	}
	
	private boolean lastFrame(int numberFrame) {
		return numberFrame == 9;
	}
	
	private boolean existFrame(int numberFrame) {
		return frames.size()>numberFrame;
	}
	
}
