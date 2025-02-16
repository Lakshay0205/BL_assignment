package LinearSearch;

import java.util.List;

public class SentenceSearch {

    public static String findSentenceContainingWord(List<String> sentences, String targetWord) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(targetWord.toLowerCase())) { // Case-insensitive search
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<String> sentences = List.of(
                "This is the first sentence.",
                "The second sentence is here.",
                "A third sentence exists.",
                "No match here."
        );
        String targetWord = "second";

        String result = findSentenceContainingWord(sentences, targetWord);
        System.out.println(result);


        targetWord = "match";
        result = findSentenceContainingWord(sentences, targetWord);
        System.out.println(result);

        targetWord = "not found";
        result = findSentenceContainingWord(sentences, targetWord);
        System.out.println(result);


    }
}