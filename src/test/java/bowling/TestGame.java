package bowling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {

	//Give When Then
	//Dado Cuando Entonces
	
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
	void tiro1Derribo5Tiro2Derribo3Puntuacion8() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(3);
		assertEquals(8, game.score());
	}
	
	@Test
	void cuadro1SpareCuadro2Tiro1Derribo5Puntuacion20() throws Exception {
		Game game = new Game();
		game.roll(4);
		game.roll(6);
		
		game.roll(5);
		
		assertEquals(20, game.score());
	}
	
	@Test
	void cuadro1SpareCuadro2Tiro1Derribo8Puntuacion26() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(8);
		
		assertEquals(26, game.score());
	}
	
	@Test
	void cuadro1SpareCuadro2Tiro1Derribo8Tiro2Derribo1Puntuacion27() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(8);
		game.roll(1);
		
		assertEquals(27, game.score());
	}
	
	@Test
	void cuadro1_5_5_spare_cuadro2_4_6_spare_puntuacion24() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(4);
		game.roll(6);
		
		assertEquals(24, game.score());
	}
	
	@Test
	void cuadro1_5_5_Spare_Cuadro2_4_6_Spare_Cuadro3_5Puntuacion34() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(4);
		game.roll(6);
		
		game.roll(5);
		
		assertEquals(34, game.score());
	}
	
	@Test
	void cuadro1_5_4_Cuadro2_6_0_Cuadro3_5_3_Cuadro4_8_2_Cuadro5_4_2Puntuacion43() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(4);
		
		game.roll(6);
		game.roll(0);
		
		game.roll(5);
		game.roll(3);
		
		game.roll(8);
		game.roll(2);

		game.roll(4);
		game.roll(2);
		
		assertEquals(43, game.score());
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
