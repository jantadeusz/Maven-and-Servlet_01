package pl.coderslab.service;

public class TextService {


    public static String[] uncensureWords = {"cholera", "kurza stopa"};


    public static String censureText(String text) {
        String newText = text;

        for (String fraze : uncensureWords) {
            String stars = fraze.replaceAll(".", "*");
            newText = newText.replaceAll(fraze, stars);
        }
        return newText;
    }
}
