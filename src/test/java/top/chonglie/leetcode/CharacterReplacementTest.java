package top.chonglie.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CharacterReplacementTest {
    CharacterReplacement characterReplacement = new CharacterReplacement();

    @ParameterizedTest
    @CsvSource({
            "A, 1, 1"
            , "ABAB, 2, 4"
            , "AABABBA, 1, 4"
            , "BAAAB, 2, 5"
    })
    void testCharacterReplacement(String s, int k, int expected) {
        Assertions.assertEquals(expected, characterReplacement.characterReplacement(s, k));
    }
}
