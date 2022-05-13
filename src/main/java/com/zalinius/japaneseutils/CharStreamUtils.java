package com.zalinius.japaneseutils;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class CharStreamUtils {
	private CharStreamUtils() {}
	
	public static Character makeChar(String singleCharString) {
		if(singleCharString.length() != 1) {
			throw new IllegalArgumentException();
		}
		
		return (char) singleCharString.codePointAt(0);
	}
	
	public static Stream<Character> stream(String string){
		return string.codePoints().mapToObj(c -> (char) c);
	}
	
	public static Iterator<Character> iterator(String string){
		return characters(string).iterator();
	}

	private static List<Character> characters(final String string) {
		return new AbstractList<>() {
		        @Override
		    public Character get(int index) {
		            return string.charAt(index);
		        }

		        @Override
		    public int size() {
		            return string.length();
		        }
		    };
		}

}
