package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

	public static final String VALOR_INVALIDO = "El valor de los pinos es invalido";
	private List<Frame> frames;
	private int score;
	private int count;
	
	public Game() {
		score = 0;
		count = 0;
		frames = new ArrayList<Frame>();
	}

	public void roll(int pins) throws Exception {
		if(pins>10) {
			throw new Exception(VALOR_INVALIDO);
		}
		Frame frame;
		if(count==0) {
			frame=new Frame();
			frame.setRollOne(pins);
			frames.add(frame);
			count++;
		}else {
			frame=frames.get(frames.size()-1);
			frame.setRollTwo(pins);
			frames.set(frames.size()-1, frame);
			count=0;
		}
	}
	
	public int score() {
		score=0;
		for (int numberFrame = 0; numberFrame < frames.size(); numberFrame++) {
			Frame frame = frames.get(numberFrame);
			int totalFrame = frame.getRollOne() + frame.getRollTwo();
			score+=totalFrame;
			if(totalFrame==10 && frames.size()>(numberFrame+1)) {
				Frame frameNext = frames.get(numberFrame+1);
				score+=frameNext.getRollOne();
			}
		}
		return score;
	}
	
}
