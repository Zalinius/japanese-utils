package com.zalinius.japaneseutils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HiraganaUtils {
	
	private HiraganaUtils() {}

	public static String makeSmall(String string) {
		List<Character> chars = arrayToListConversion(string.toCharArray());
		return chars.stream().map(c -> makeSmall(c)).map(c -> c.toString()).collect(Collectors.joining());
	}

	public static String makeLarge(String string) {
		List<Character> chars = arrayToListConversion(string.toCharArray());
		return chars.stream().map(c -> makeLarge(c)).map(c -> c.toString()).collect(Collectors.joining());
	}

	public static Character makeSmall(Character hiragana) {
		Character potentialSmallHiragana = decrementCodePoint(hiragana);

		if(smallHiragana.contains(potentialSmallHiragana)) {
			return potentialSmallHiragana;
		}
		else {
			return hiragana;
		}
	}

	public static Character makeLarge(Character hiragana) {
		if(smallHiragana.contains(hiragana)) {
			return incrementCodePoint(hiragana);
		}
		else {
			return hiragana;
		}
	}

	private static Character incrementCodePoint(Character character) {
		return changeCodePoint(character, 1);
	}

	private static Character decrementCodePoint(Character character) {
		return changeCodePoint(character, -1);
	}

	private static Character changeCodePoint(Character character, int amount) {
		int originalCodePoint = Character.codePointAt(character.toString(), 0);
		Character newCodePoint = Character.toChars(originalCodePoint + amount)[0];
		return newCodePoint;
	}
	
	public static boolean isHiragana(Character character) {
		int minHiragana = Character.codePointAt("ぁ", 0);
		int maxHiragana = Character.codePointAt("ゖ", 0);

		int charPosition = Character.codePointAt(character.toString(), 0);
		
		return minHiragana <= charPosition && charPosition <= maxHiragana;
	}
	
	public static boolean containsOnlyHiragana(String string) {
		return string.codePoints().mapToObj(c -> (char) c).allMatch(HiraganaUtils::isHiragana);
	}

	public static List<Character> smallHiragana = Arrays.asList('っ', 'ゃ', 'ゅ', 'ょ');


	public static List<Character> arrayToListConversion(char[] array)   
	{   
		List<Character> list = new ArrayList<>();   
		for (char c : array)   
		{   
			list.add(c);   
		}   
		return list;   
	}   

}
