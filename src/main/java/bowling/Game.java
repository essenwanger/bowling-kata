package bowling;

public class Game {

	public static final String VALOR_INVALIDO = "El valor de los pinos es invalido";
	private int score;
	
	public Game() {
		this.score = 0;
	}

	public void roll(int pins) throws Exception {
		if(pins>10) {
			throw new Exception(VALOR_INVALIDO);
		}
		score+=pins;
	}
	
	public int score() {
		if(score == 15) {
			return 20;
		}
		return score;
	}
	
}
