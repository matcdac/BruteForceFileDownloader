package d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HitApi {

	private String basePath = null;
	private Set<String> extensions = null;
	private int minChars;
	private int maxChars;
	
	private static List<Character> urlCharacters = new ArrayList<Character>();
	private static Set<Character> urlSpecialCharacters = new HashSet<Character>();
	
	private Map<Integer, List<Integer>> lengthVsNextGeneratePositionMapping = null;
	private Map<Integer, Boolean> digitVsProgress = null;
	
	static {
		addCharacters();
		addSpecialCharacters();
	}

	private static void addCharacters() {
		int ascii;
		for(ascii = 97; ascii <= 122; ascii++)
			urlCharacters.add((char) ascii);
		for(ascii = 65; ascii <= 90; ascii++)
			urlCharacters.add((char) ascii);
		for(ascii = 48; ascii <= 57; ascii++)
			urlCharacters.add((char) ascii);
		// underscore
		urlCharacters.add((char) 95);
	}
	
	private static void addSpecialCharacters() {
		int[] special = { 36, 38, 43, 44, 47, 58, 59, 61, 63, 64, 32, 34, 60, 62, 35, 37, 123, 125, 124, 92, 94, 126, 91, 93, 96, 46};
		for(int ch: special)
			urlSpecialCharacters.add((char) ch);
	}
	
	public HitApi(String basePath, Set<String> extensions, int minChars, int maxChars) {
		this.basePath = basePath;
		this.extensions = extensions;
		this.minChars = minChars;
		this.maxChars = maxChars;
		lengthVsNextGeneratePositionMapping = new HashMap<Integer, List<Integer>>();
		digitVsProgress = new HashMap<Integer, Boolean>();
		for(int n = minChars; n <= maxChars; n++) {
			List<Integer> listOfPositionsOfSizeN = new ArrayList<Integer>(n);
			for(int index = 0; index < n; index++)
				listOfPositionsOfSizeN.add(index, 0);
			lengthVsNextGeneratePositionMapping.put(n, listOfPositionsOfSizeN);
			digitVsProgress.put(n, false);
		}
		digitVsProgress.put(minChars, true);
	}
	
	private Integer getWordLengthToBeGenerated() {
		for(Integer digit : digitVsProgress.keySet()) {
			if(digitVsProgress.get(digit)) {
				return digit;
			}
		}
		return null;
	}
	
	private void incrementProgress(Integer currentLength, List<Integer> currentPosition) {
		for(int index = currentLength-1; index >= 0; index--) {
			int value = currentPosition.get(index);
			if(value == urlCharacters.size()-1) {
				currentPosition.set(index, 0);
				if(index == 0) {
					if(currentLength == maxChars) {
						digitVsProgress.put(currentLength, false);
					} else {
						digitVsProgress.put(currentLength, false);
						digitVsProgress.put(currentLength+1, true);
					}
				} else {
					continue;
				}
			} else {
				currentPosition.set(index, value+1);
				break;
			}
		}
	}
	
	public String getNextWord() {
		Integer length = getWordLengthToBeGenerated();
		List<Integer> nextGeneratePosition = null;
		if(null != length)
			nextGeneratePosition = lengthVsNextGeneratePositionMapping.get(length);
		if(null != nextGeneratePosition) {
			StringBuffer word = new StringBuffer();
			for(int indexPointer : nextGeneratePosition) {
				word.append(urlCharacters.get(indexPointer));
			}
			incrementProgress(length, nextGeneratePosition);
			return word.toString();
		} else {
			return null;
		}
	}

}
