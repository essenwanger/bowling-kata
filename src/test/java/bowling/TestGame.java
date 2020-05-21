package bowling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {

	@Test
	void primerTiroNoDerriboNadaPuntuacion0() throws Exception {
		Game game = new Game();
		game.roll(0);
		assertEquals(0, game.score());
	}
	
	@Test
	void primerTiroDerribo5Puntuacion5() throws Exception {
		Game game = new Game();
		game.roll(5);
		assertEquals(5, game.score());
	}

	@Test
	void test1() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(3);
		assertEquals(8, game.score());
	}
	
	@Test
	void test2() throws Exception {
		Game game = new Game();
		frame1Spare(game);
		frame2primerTiro5(game);
		
		assertEquals(20, game.score());
	}

	public void frame2primerTiro5(Game game) throws Exception {
		game.roll(5);
	}

	public void frame1Spare(Game game) throws Exception {
		game.roll(5);
		game.roll(5);
	}
	
	@Test
	void derribaMasDe10EsInvalido() {
		Game game = new Game();
		try {
			game.roll(11);
			fail();
		} catch (Exception e) {
			assertEquals(e.getMessage(), Game.VALOR_INVALIDO);
		}
	}
	
}
