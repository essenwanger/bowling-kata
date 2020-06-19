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
		if(count==0 && pins<10) {
			frame=new Frame();
			frame.setRollOne(pins);
			frames.add(frame);
			count++;
		}else if(count==0 && pins==10){
			frame=new Frame();
			frame.setRollOne(pins);
			frames.add(frame);
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
			if(frame.getRollOne() == 10 && frames.size()>(numberFrame+1)) {
				Frame frameNext = frames.get(numberFrame+1);
				score+=frameNext.getRollOne();
				if(frameNext.getRollOne()==10 && frames.size()>(numberFrame+2)) {
					Frame frameNextNext = frames.get(numberFrame+2);
					score+=frameNextNext.getRollOne();
				}
				score+=frameNext.getRollTwo();
			}else if(totalFrame==10 && frames.size()>(numberFrame+1)) {
				Frame frameNext = frames.get(numberFrame+1);
				score+=frameNext.getRollOne();
			}
		}
		return score;
	}
	
}
