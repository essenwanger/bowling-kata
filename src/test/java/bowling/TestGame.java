package bowling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGame {

	//Give When Then
	//Dado Cuando Entonces
	
	@Test
	void cuadro1_0_Puntuacion0() throws Exception {
		Game game = new Game();
		game.roll(0);
		assertEquals(0, game.score());
	}
	
	@Test
	void cuadro1_5_Puntuacion5() throws Exception {
		Game game = new Game();
		game.roll(5);
		assertEquals(5, game.score());
	}

	@Test
	void cuadro1_5_3_Puntuacion8() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(3);
		assertEquals(8, game.score());
	}
	
	@Test
	void cuadro1_5_4_Cuadro2_6_0_Cuadro3_5_3_Cuadro4_8_2_Cuadro5_4_2_Puntuacion43() throws Exception {
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
	void cuadro1_4_6_Spare_Cuadro2_5_Puntuacion20() throws Exception {
		Game game = new Game();
		game.roll(4);
		game.roll(6);
		
		game.roll(5);
		
		assertEquals(20, game.score());
	}
	
	@Test
	void cuadro1_5_5_Spare_Cuadro2_8_Puntuacion26() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(8);
		
		assertEquals(26, game.score());
	}
	
	@Test
	void cuadro1_5_5_Spare_Cuadro2_8_1_Puntuacion27() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(8);
		game.roll(1);
		
		assertEquals(27, game.score());
	}
	
	@Test
	void cuadro1_5_5_Spare_Cuadro2_4_6_Spare_Puntuacion24() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(4);
		game.roll(6);
		
		assertEquals(24, game.score());
	}
	
	@Test
	void cuadro1_5_5_Spare_Cuadro2_4_6_Spare_Cuadro3_5_Puntuacion34() throws Exception {
		Game game = new Game();
		game.roll(5);
		game.roll(5);
		
		game.roll(4);
		game.roll(6);
		
		game.roll(5);
		
		assertEquals(34, game.score());
	}
	
	@Test
	void cuadro1_0_10_Spare_Cuadro2_4_4_Puntuacion22() throws Exception {
		Game game = new Game();
		game.roll(0);
		game.roll(10);
		
		game.roll(4);
		game.roll(4);
		
		assertEquals(22, game.score());
	}

	@Test
	void cuadro1_10_Strike_Cuadro2_4_4_Puntuacion26() throws Exception {
		Game game = new Game();
		game.roll(10);
		
		game.roll(4);
		game.roll(4);
		
		assertEquals(26, game.score());
	}
	
	@Test
	void cuadro1_10_Strike_Cuadro2_4_Puntuacion18() throws Exception {
		Game game = new Game();
		game.roll(10);
		
		game.roll(4);
		
		assertEquals(18, game.score());
	}
	
	@Test
	void cuadro1_10_Strike_Cuadro2_10_Strike_Cuadro3_4_Puntuacion42() throws Exception {
		Game game = new Game();
		game.roll(10);
		
		game.roll(10);
		
		game.roll(4);
		
		assertEquals(42, game.score());
	}
	
	@Test
	void cuadro1_10_Strike_Cuadro2_10_Strike_Cuadro3_10_Strike_Puntuacion60() throws Exception {
		Game game = new Game();
		game.roll(10);
		
		game.roll(10);
		
		game.roll(10);
		
		assertEquals(60, game.score());
	}
	
	@Test
	void cuadro1_10_Strike_Cuadro2_10_Strike_Cuadro3_10_Strike_Cuadro4_10_Strike_Puntuacion90() throws Exception {
		Game game = new Game();
		game.roll(10);
		
		game.roll(10);
		
		game.roll(10);
		
		game.roll(10);
		
		assertEquals(90, game.score());
	}
	
	@Test
	void cuadro1_10_3_3_Puntuacion60() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=10) {
			game.roll(3);
			game.roll(3);
			count++;
		}
		
		assertEquals(60, game.score());
	}
	
	@Test
	void cuadro1_9_3_3_cuadro10_5_4_Puntuacion63() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=9) {
			game.roll(3);
			game.roll(3);
			count++;
		}

		game.roll(5);
		game.roll(4);
		
		assertEquals(63, game.score());
	}
	
	@Test
	void cuadro1_10_5_5_Spare_Extra_5_Puntuacion150() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=10) {
			game.roll(5);
			game.roll(5);
			count++;
		}

		game.roll(5);
		
		assertEquals(150, game.score());
	}
	
	@Test
	void cuadro1_9_10_Strike_Cuadro10_5_3_Puntuacion261() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=9) {
			game.roll(10);
			count++;
		}

		game.roll(5);
		game.roll(3);
		
		assertEquals(261, game.score());
	}
	
	@Test
	void cuadro1_9_10_Strike_Cuadro10_4_6_Spare_Extra_5_Puntuacion269() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=9) {
			game.roll(10);
			count++;
		}

		game.roll(4);
		game.roll(6);
		
		game.roll(5);
		
		assertEquals(269, game.score());
	}
	
	@Test
	void cuadro1_10_10_Strike_5_5_Puntuacion285() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=10) {
			game.roll(10);
			count++;
		}
		
		game.roll(5);
		game.roll(5);
		
		assertEquals(285, game.score());
	}
	
	@Test
	void cuadro1_10_10_Strike_10_5_Puntuacion295() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=10) {
			game.roll(10);
			count++;
		}
		
		game.roll(10);
		game.roll(5);
		
		assertEquals(295, game.score());
	}
	
	@Test
	void cuadro1_10_10_Strike_10_10_Puntuacion300() throws Exception {
		Game game = new Game();
		
		int count = 0;
		while (count!=10) {
			game.roll(10);
			count++;
		}
		
		game.roll(10);
		game.roll(10);
		
		assertEquals(300, game.score());
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
