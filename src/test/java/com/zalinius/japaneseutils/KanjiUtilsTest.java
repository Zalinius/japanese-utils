package com.zalinius.japaneseutils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class KanjiUtilsTest {
	
	@Test
	void countKanji_onString_countsKanji() throws Exception {
		String string = "一「王」は、一主に東アジア地域一において用いられた爵位の一つ。";
		
		Map<Character, Integer> kanjiCounts = KanjiUtils.countKanji(string);
		
		assertEquals(9, kanjiCounts.size());
		assertEquals(4, kanjiCounts.get('一'));
		assertEquals(1, kanjiCounts.get('用'));
		assertFalse(kanjiCounts.containsKey('項'));
		
	}
	
	@Test
	void stripOutNonKanji_onString_leavesOnlyKanji() throws Exception {
		String string = "「王」は、主に東アジア地域において用いられた爵位の一つ。";
		
		String strippedString = KanjiUtils.stripOutNonKanji(string);
		
		assertEquals("王主東地域用爵位一", strippedString);
	}


	@ParameterizedTest
	@ValueSource(chars = {'一', '金', '角', '々', '万', '鳖'})
	public void isKanji_onKanji_isTrue(Character kanji) throws Exception {
		boolean result = KanjiUtils.isKanji(kanji);

		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(chars = {'a', 'ア', 'ジ', 'ワ', '9', 'ッ', 'ト', 'ニ'})
	public void isKanji_onNonKanji_isFalse(Character kanji) throws Exception {
		boolean result = KanjiUtils.isKanji(kanji);

		assertFalse(result);
	}

}
