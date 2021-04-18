package com.company;

import java.util.HashMap;
import java.util.Map;


public class Parser {

    public static Map<Fields, String> parseSCR(String str) {

        String word = "";
        int x = 0;

        Map<Fields, String> scrData = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '\n') {//не считать перенос строки как слово
                if (str.charAt(i + 1) == '\n') {
                    continue;
                }
                scrData.put(Fields.fieldNames[x++], word);
                word = "";
                continue;

            } else if (str.charAt(i) == ' ') {//не считать пробелы как слово
                if (str.charAt(i + 1) == ' ') {
                    continue;
                }
                scrData.put(Fields.fieldNames[x++], word);
                word = "";
            } else {
                if (str.charAt(i) == 'S' && str.charAt(i + 1) == 'I') {

                    for (int j = i; j < str.length(); j++) {

                        if (str.charAt(j) == '\n' && str.charAt(j + 1) == 'G' && str.charAt(j + 2) == 'I') {
                            scrData.put(Fields.fieldNames[x++],word);
                            word = "";
                            for (int k = j + 1; k < str.length(); k++) {
                                word += str.charAt(k);
                            }
                            break;
                        }
                        word += str.charAt(j);
                    }
                    scrData.put(Fields.fieldNames[x++], word);
                    break;
                } else {
                    if (str.charAt(i) == 'G' && str.charAt(i + 1) == 'I') {
                        for (int j = i; j < str.length(); j++) {
                            word += str.charAt(j);
                            if (j == str.length() - 1) {
                                scrData.put(Fields.fieldNames[x+1],word);
                                word = "";
                                break;
                            }
                        }
                        break;
                    }

                    word += str.charAt(i);
                }
            }
        }

        return scrData;

    }
}


