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
		assertEquals(Welcome.welcome("Bob,Jerry"), "Hello, Bob and Jerry");
		assertEquals(Welcome.welcome("Jerry,Bob"), "Hello, Jerry and Bob");
		assertEquals(Welcome.welcome("bob,jerry"), "Hello, Bob and Jerry");
	}

	@Test
	void helloFriends() {
		assertEquals(Welcome.welcome("Bob, Jerry, Amy"), "Hello, Bob, Jerry and Amy");
		assertEquals(Welcome.welcome("Jerry,Bob, amy"), "Hello, Jerry, Bob and Amy");
		assertEquals(Welcome.welcome("bob, jerry,Amy"), "Hello, Bob, Jerry and Amy");
	}

	@Test
	void helloShoutFriends() {
		assertEquals(Welcome.welcome("Bob, JERRY, Amy"), "Hello, Bob and Amy. AND HELLO, JERRY !");
		assertEquals(Welcome.welcome("Jerry,BOB, amy"), "Hello, Jerry and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("bob, JERRY,Amy"), "Hello, Bob and Amy. AND HELLO, JERRY !");
	}

	@Test
	void helloShoutAndFriends() {
		assertEquals(Welcome.welcome("Bob, JERRY, AMY"), "Hello, Bob. AND HELLO, JERRY AND AMY !");
		assertEquals(Welcome.welcome("Jerry,BOB, amy"), "Hello, Jerry and Amy. AND HELLO, BOB !");
		assertEquals(Welcome.welcome("BOB, JERRY,Amy"), "Hello, Amy. AND HELLO, BOB AND JERRY !");
	}
}
