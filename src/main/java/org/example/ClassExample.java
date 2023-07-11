package org.example;

import java.util.function.Predicate;

public class ClassExample {

    public static Predicate<String> testP;
    static String correct(String sentence){

        StringBuilder result = new StringBuilder();
        String[] split = sentence.split(" ");

        //the argument name: "someWords" and "words" shows that we can name our lambda arguments
        //using any name
        Predicate<String> isEqualU = someWords-> someWords.equals("U")||someWords.equals("u");

        Predicate<String> startsOrEnds = word-> word.endsWith("uu")||word.startsWith("uu");

        Predicate<String> isItYou = word-> word.length()==3&&word.equals("you");

        for (int i = 0; i < split.length; i++) {
//            if(split[i].equals("U")||split.equals("u")){
//                split[i] = "your client";
//            }
//            commented as above is the same as below
            if(isEqualU.test(split[i])){
                split[i] = "your client";
            }
            if (startsOrEnds.test(split[i])) {
                split[i] = "your client";
            }
            if(isItYou.test(split[i])){
                split[i] = "your client";
            }
            result.append(split[i]).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(correct("Did the opponent tell you that you would loose the case?"));
    }
}