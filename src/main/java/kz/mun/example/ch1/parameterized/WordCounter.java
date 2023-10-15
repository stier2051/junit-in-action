package kz.mun.example.ch1.parameterized;

public class WordCounter {
    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}
