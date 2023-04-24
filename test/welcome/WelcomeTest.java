package welcome;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void helloBob() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("Bob"), "Hello, Bob");
	}

	@Test
	void helloFriend() {
		assertEquals(Welcome.welcome(null), "Hello, my friend");
		assertEquals(Welcome.welcome("    "), "Hello, my friend");
	}

	@Test
	void HELLOFULLCAPS() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY !");
		assertEquals(Welcome.welcome("BOB"), "HELLO, BOB !");
	}

	@Test
	void helloTwoFriends() {
		assertEquals(Welcome.welcome("Bob,Jerry"), "Hello, Bob, Jerry");
		assertEquals(Welcome.welcome("Jerry,Bob"), "Hello, Jerry, Bob");
		assertEquals(Welcome.welcome("bob,jerry"), "Hello, Bob, Jerry");
	}

	void helloFriends() {
		assertEquals(Welcome.welcome("Bob, Jerry, Amy"), "Hello, Bob, Jerry, Amy");
		assertEquals(Welcome.welcome("Jerry,Bob, amy"), "Hello, Jerry, Bob, Amy");
		assertEquals(Welcome.welcome("bob, jerry,Amy"), "Hello, Bob, Jerry, Amy");
	}
}
