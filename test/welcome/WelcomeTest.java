package welcome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void EX_1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
	}

	@Test
	void EX_2() {
		assertEquals(Welcome.welcome(null), "Hello, my friend");
		assertEquals(Welcome.welcome("    "), "Hello, my friend");
	}

	@Test
	void EX_3() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
		assertEquals(Welcome.welcome("BOB"), "HELLO, BOB !");
	}

	@Test
	void EX_4() {
		assertEquals(Welcome.welcome("Bob,Jerry"), "Hello, Bob and Jerry");
		assertEquals(Welcome.welcome("Jerry,Bob"), "Hello, Jerry and Bob");
		assertEquals(Welcome.welcome("bob,jerry"), "Hello, Bob and Jerry");
	}

	@Test
	void EX_5() {
		assertEquals(Welcome.welcome("Bob, Jerry, Amy"), "Hello, Bob, Jerry and Amy");
		assertEquals(Welcome.welcome("Jerry,Bob, amy"), "Hello, Jerry, Bob and Amy");
		assertEquals(Welcome.welcome("bob, jerry,Amy"), "Hello, Bob, Jerry and Amy");
	}

	@Test
	void EX_6() {
		assertEquals(Welcome.welcome("Bob, JERRY, Amy"), "Hello, Bob and Amy. AND HELLO, JERRY !");
		assertEquals(Welcome.welcome("Jerry,BOB, amy"), "Hello, Jerry and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("bob, JERRY,Amy"), "Hello, Bob and Amy. AND HELLO, JERRY !");
	}

	@Test
	void EX_7() {
		assertEquals(Welcome.welcome("Bob, JERRY, AMY"), "Hello, Bob. AND HELLO, JERRY AND AMY !");
		assertEquals(Welcome.welcome("Jerry,BOB, amy"), "Hello, Jerry and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("BOB, JERRY,Amy"), "Hello, Amy. AND HELLO, BOB AND JERRY !");
	}

	@Test
	void EX_8() {
		assertEquals(Welcome.welcome("Bob     ,     JERRY, AMY   "), "Hello, Bob. AND HELLO, JERRY AND AMY !");
		assertEquals(Welcome.welcome("Jerry   ,BOB,       amy"), "Hello, Jerry and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("     BOB,    JERRY,Amy    "), "Hello, Amy. AND HELLO, BOB AND JERRY !");
	}

	@Test
	void EX_9() {
		assertEquals(Welcome.welcome("Bob, JERRY, AMY, bob"), "Hello, Bob(x2). AND HELLO, JERRY AND AMY !");
		assertEquals(Welcome.welcome("Jerry,BOB, amy, Jerry, jerry"), "Hello, Jerry(x3) and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("BOB, JERRY,Amy ,     BOB"), "Hello, Amy. AND HELLO, BOB(x2) AND JERRY !");
	}

	@Test
	void EX_10() {
		assertEquals(Welcome.welcome("Bob, JERRY, YODA, bob"), "Hello, Bob(x2). AND JERRY AND YODA, HELLO !");
		assertEquals(Welcome.welcome("Yoda,BOB, amy, Jerry, yoda"), "Yoda(x2), Amy and Jerry, Hello. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("BOB, JERRY,yoda ,     BOB"), "Yoda, Hello. AND HELLO, BOB(x2) AND JERRY !");
		assertEquals(Welcome.welcome("yoda"), "Yoda, Hello");
		assertEquals(Welcome.welcome("YODA"), "YODA, HELLO !");
	}
}
