package com.json.parser;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static void main(String args[]) {

        String someString = " { name : Faisal, { city : Cardiff}, {name : Blah, city : Newport}";


        System.out.println(getNextObject(someString));

    }

    public static List<String> getNextObject(String content) {

        List<String> tokenizedList = new ArrayList<>();

        StringBuilder object = null;

        int nextCharIndex = 0;

        char nextChar = ' ';

        int contentLength = content.length();

        while ( nextCharIndex < contentLength) {

            nextChar = content.charAt(nextCharIndex);
             if(nextChar == '{') {

                 object = new StringBuilder();
                 object.append(nextChar);

                while (++nextCharIndex < content.length()) {

                    nextChar = content.charAt(nextCharIndex);
                    object.append(nextChar);

                    if(nextChar == '}') {
                        break;
                    }
                    else if (nextChar == '{' || nextChar == '[') {
                        throw new IllegalArgumentException("Not a valid JSON Object");
                    }
                }

                if(validateJsonObject(object.toString()))
                        tokenizedList.add(object.toString());
            }
            nextCharIndex++;
        }

        return tokenizedList;
    }

    public static boolean validateJsonObject(String jsonObject) {

        if (jsonObject.contains(",,")) {
            return false;
        }

        for (int i = 0; i < jsonObject.length(); i++) {

            if(jsonObject.charAt(i) == '{') {

                int nextCharIndex = i;

                while(++nextCharIndex < jsonObject.length()) {

                    if(jsonObject.charAt(nextCharIndex) == '}') {
                        return true;
                    }

                    else if(jsonObject.charAt(nextCharIndex) == '{') {
                        return false;
                    }
                }

                if(jsonObject.charAt(jsonObject.length() - 1) != '}') {
                    return false;
                }
            }
        }

        return true;    // Assume all is well
    }
}
