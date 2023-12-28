package kz.mun.example.parameterized;

import kz.mun.example.ch2.parameterized.Sentences;
import kz.mun.example.ch2.parameterized.WordCounter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterizedWithEnumTest {
    private final WordCounter wordCounter = new WordCounter();

    @ParameterizedTest
    @EnumSource(Sentences.class)
    void testWordsInSentence(Sentences sentences) {
//        assertEquals(3, wordCounter.countWords(sentences.value()));
    }

    @ParameterizedTest
    @EnumSource(value = Sentences.class, names = {"JUNIT_IN_ACTION", "FAIL"})
    void testSelectedWordsInSentence(Sentences sentence) {
//        assertEquals(3, wordCounter.countWords(sentence.value()));
    }

    @ParameterizedTest
    @EnumSource(value = Sentences.class, mode = EnumSource.Mode.EXCLUDE, names = { "THREE_PARAMETERS" })
    void testExcludedWordsInSentence(Sentences sentence) {
//        assertEquals(3, wordCounter.countWords(sentence.value()));
    }
}
