package welcome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void hello_bob() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
	}

	@Test
	void hello_friend() {
		assertEquals(Welcome.welcome(null), "Hello, my friend");
		assertEquals(Welcome.welcome("    "), "Hello, my friend");
	}

	@Test
	void HELLO_FULLCAPS() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
	}
}
