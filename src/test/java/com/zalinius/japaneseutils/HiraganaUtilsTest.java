package com.zalinius.japaneseutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class HiraganaUtilsTest {

	@ParameterizedTest
	@ValueSource(strings = {"apple", "水中", "9つ", "テーブルの上", "イギリス"})
	public void containsOnlyHiragana_onNonHiragana_isFalse(String string) throws Exception {
		boolean result = HiraganaUtils.containsOnlyHiragana(string);

		assertFalse(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"おうきょう", "うらみち", "じゅうろく", "おはよう", ""})
	public void containsOnlyHiragana_onHiragana_isTrue(String hiraganaString) throws Exception {
		boolean result = HiraganaUtils.containsOnlyHiragana(hiraganaString);

		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(chars = {'ぁ', 'ち', 'じ', 'く', 'づ', 'っ'})
	public void isHiragana_onHiragana_isTrue(Character hiragana) throws Exception {
		boolean result = HiraganaUtils.isHiragana(hiragana);

		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(chars = {'a', 'ア', 'ジ', 'ワ', '9', 'ッ'})
	public void isHiragana_onNonHiragana_isFalse(Character hiragana) throws Exception {
		boolean result = HiraganaUtils.isHiragana(hiragana);

		assertFalse(result);
	}

	@Test
	void makeSmall_onRegularHiraganaString_returnsSmallHiraganaString() {
		String regularString = "きよう";

		String result = HiraganaUtils.makeSmall(regularString);

		assertEquals("きょう", result);
	}

	@Test
	void makeLarge_onSmallHiraganaString_returnsRegularHiraganaString() {
		String regularString = "きょう";

		String result = HiraganaUtils.makeLarge(regularString);

		assertEquals("きよう", result);
	}

	@ParameterizedTest
	@CsvSource({"や,ゃ", "ゆ,ゅ", "よ,ょ", "つ,っ"})
	void makeSmall_onRegularHiragana_returnsASmallHiragana(Character regularHiragana, Character expectedSmallHiragana) throws Exception {		
		Character result = HiraganaUtils.makeSmall(regularHiragana);

		assertEquals(expectedSmallHiragana, result);
	}

	@ParameterizedTest
	@ValueSource(chars = {'ち', 'じ', 'く', 'づ'})
	public void makeSmall_onHiraganaWithoutSmallEquivalent_returnsTheSameHiragana(Character hiragana) throws Exception {
		Character result = HiraganaUtils.makeSmall(hiragana);

		assertEquals(hiragana, result);
	}

	@ParameterizedTest
	@CsvSource({"ゃ,や", "ゅ,ゆ", "ょ,よ", "っ,つ"})
	void makeLarge_onSmallHiragana_returnsTheRegularHiragana(Character smallHiragana, Character expectedRegularHiragana) throws Exception {		
		Character result = HiraganaUtils.makeLarge(smallHiragana);

		assertEquals(expectedRegularHiragana, result);
	}

	@ParameterizedTest
	@ValueSource(chars = {'ち', 'じ', 'く', 'づ'})
	public void makLarge_onHiraganaWithoutWhichIsNotSmall_returnsTheSameHiragana(Character hiragana) throws Exception {
		Character result = HiraganaUtils.makeLarge(hiragana);

		assertEquals(hiragana, result);
	}
}
