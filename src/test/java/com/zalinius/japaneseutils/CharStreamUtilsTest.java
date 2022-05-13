package com.zalinius.japaneseutils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class CharStreamUtilsTest {

	@Test
	void makeChar_fromStringNotContaining1Character_throwsIllegalArgumentException() throws Exception {
		String emptyString = "";
		String manyCharacterString = "abcd";

		assertThrows(IllegalArgumentException.class, () -> CharStreamUtils.makeChar(emptyString));
		assertThrows(IllegalArgumentException.class, () -> CharStreamUtils.makeChar(manyCharacterString));
	}

	@Test
	void makeChar_fromSingleCharacterString_returnsExpectedCharacter() throws Exception {
		String letterString = "A";
		String spaceString = " ";
		String kanjiString = "猫";

		char letterChar = CharStreamUtils.makeChar(letterString);
		char spaceChar = CharStreamUtils.makeChar(spaceString);
		char kanjiChar = CharStreamUtils.makeChar(kanjiString);

		assertEquals('A', letterChar);
		assertEquals(' ', spaceChar);
		assertEquals('猫', kanjiChar);
	}

	@Test
	void iterator_fromString_returnsStringAsCharacterIterator() throws Exception {
		String string = "ABC";

		Iterator<Character> it = CharStreamUtils.iterator(string);

		assertTrue(it.hasNext());
		char firstChar = it.next();

		assertTrue(it.hasNext());
		char secondChar = it.next();

		assertTrue(it.hasNext());
		char thirdChar = it.next();

		assertFalse(it.hasNext());
		assertEquals('A', firstChar);
		assertEquals('B', secondChar);
		assertEquals('C', thirdChar);
	}





}
