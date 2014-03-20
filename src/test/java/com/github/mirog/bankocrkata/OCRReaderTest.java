package com.github.mirog.bankocrkata;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class OCRReaderTest {
    
    @Test
    public void shouldReturnThrees() {
        String input = "123456789";
        List<String> expectedOutput = Arrays.asList("123", "456", "789");
        
        List<String> output = new OCRReader().lineToThrees(input);
        
        assertEquals(expectedOutput, output);
        
    }

    @Test
    public void shouldReturnListOfThrees() {
        List<String> input = Arrays.asList("123456789", "abcdefghi");
        List<List<String>> expectedOutput = Arrays.asList(
                Arrays.asList("123", "456", "789"),
                Arrays.asList("abc", "def", "ghi")
        );

        List<List<String>> output = new OCRReader().linesToThrees(input);

        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void shouldReturnDigitStrings() {
        List<List<String>> input = Arrays.asList(
                Arrays.asList("123", "456", "789"),
                Arrays.asList("abc", "def", "ghi"),
                Arrays.asList("jkl", "mno", "pqr"),
                Arrays.asList("stu", "vwy", "zAB")
        );
        
        List<String> expectedOutput = Arrays.asList(
                "123\nabc\njkl\nstu", "456\ndef\nmno\nvwy", "789\nghi\npqr\nzAB"
        );
        
        List<String> output = new OCRReader().linesOfThreesToDigitStrings(input);
        
        assertEquals(expectedOutput, output);
    }
    
    @Test
    public void shouldReturnDigits() throws Throwable {
        String input = "/numbers.txt";
        
        String expectedOutput = "123456789";
        
        String output = new OCRReader().readDigitsFromFile(input);
        
        assertEquals(expectedOutput, output);
    }
}
