package com.code.practice.sample.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ChangesParser {

	private static final String PATTERN_CHANGESET = "--\\s*changeset";
	private static final String COMMENT = "--\\s*comment";
	private static final String PATTERN_DASHED_LINE = "[-]{3,}";
	private static final Pattern DASHED_LINE = Pattern.compile(PATTERN_DASHED_LINE);
	
	public static void main(String[] args) {

		try {
			File file = new File("E:\\changes_Satya.sql");

			BufferedReader br = new BufferedReader(new FileReader(file));

			String st;
			StringBuffer bfr = new StringBuffer();
			while ((st = br.readLine()) != null) {
				bfr.append(st + "\n");
			}
			System.out.println(bfr);
			processChangeset(bfr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processChangeset(StringBuffer bfr) {
		
		System.out.println("---processChangeset");
		try {
			String[] changesets = bfr.toString().split(PATTERN_CHANGESET);
			for (int i = 0; i < changesets.length; i++) {
				
				changesets[i] = changesets[i].replaceAll(PATTERN_DASHED_LINE, "");
				
				parseHeader(changesets[i]);
				
				/*System.out.println("Changeset:: " + i+1);
				System.out.println(changesets[i]);*/
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void parseHeader(String string) {
		
		try {
			String[] lines = string.split("/n");
			for (int j = 0; j < lines.length; j++) {
				System.out.println("==> " + lines[j]);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
