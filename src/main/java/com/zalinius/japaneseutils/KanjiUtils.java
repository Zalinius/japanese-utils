package com.zalinius.japaneseutils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KanjiUtils {
	private KanjiUtils() {}
	
	public static Map<Character, Integer> countKanji(String string){
		string = stripOutNonKanji(string);
		
		Map<Character, Integer> map = new HashMap<>();
		
		CharStreamUtils.stream(string).forEach(c -> map.put(c, map.getOrDefault(c, 0)+1));
		
		return map;
	}
	
	public static String stripOutNonKanji(String string) {
		Stream<Character> stream = CharStreamUtils.stream(string);
		return stream.filter(KanjiUtils::isKanji).map(c -> c.toString()).collect(Collectors.joining());
	}
	
	public static boolean isKanji(Character character) {
		int minKanji = Character.codePointAt("一", 0);
		int maxKanji = Character.codePointAt("鿯", 0);

		int charPosition = Character.codePointAt(character.toString(), 0);
		
		return unusalCharacters.contains(character) || minKanji <= charPosition && charPosition <= maxKanji;
	}
	
	public static List<Character> unusalCharacters = Arrays.asList('々');

}