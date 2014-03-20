package com.github.mirog.bankocrkata;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OCRReader {

    public List<String> lineToThrees(String input) {
        if (input.isEmpty()) return new ArrayList<>();        
        List<String> rest = lineToThrees(input.substring(3));
        rest.add(0, input.substring(0, 3));
        return rest;
    }

    public List<List<String>> linesToThrees(List<String> input) {
        return input.stream().map(line -> lineToThrees(line)).collect(Collectors.<List<String>>toList());
    }

    public List<String> linesOfThreesToDigitStrings(List<List<String>> input) {
        if (input.get(0).isEmpty()) return new ArrayList<>();
        String digitString = input.stream().map(line -> line.get(0)).reduce("", (s1, s2) -> String.join(separator(s1), s1, s2));
        List<List<String>> rest = input.stream().map(line -> line.subList(1, line.size())).collect(Collectors.<List<String>>toList());
        
        List<String> result = linesOfThreesToDigitStrings(rest);
        result.add(0, digitString);
        return result;        
    }
    
    public String readDigitsFromFile(String filename) throws IOException, URISyntaxException {
        List<String> lines = Files.readAllLines(new File(getClass().getResource(filename).toURI()).toPath());
        return linesOfThreesToDigitStrings(linesToThrees(lines)).stream().map(Digits::toDigit).reduce("", String::concat);
    }
 
    private String separator(String leftSide) {
        return leftSide.isEmpty() ? "" : "\n";
    }
}
