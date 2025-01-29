public class WordReplacer {
    public static void main(String[] args) {
        String sentence = "Java is a powerful programming language.";
        String wordToReplace = "powerful";
        String replacementWord = "versatile";

        String updatedSentence = replaceWord(sentence, wordToReplace, replacementWord);

        System.out.println("Original Sentence: " + sentence);
        System.out.println("Updated Sentence: " + updatedSentence);
    }

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        return sentence.replaceAll("\\b" + wordToReplace + "\\b", replacementWord);
    }
}
