package com.github.mirog.bankocrkata;

public class Digits {
    public static final String ONE   = "   \n  |\n  |\n   ";
    public static final String TWO   = " _ \n _|\n|_ \n   ";
    public static final String THREE = " _ \n _|\n _|\n   ";
    public static final String FOUR  = "   \n|_|\n  |\n   ";
    public static final String FIVE  = " _ \n|_ \n _|\n   ";
    public static final String SIX   = " _ \n|_ \n|_|\n   ";
    public static final String SEVEN = " _ \n  |\n  |\n   ";
    public static final String EIGHT = " _ \n|_|\n|_|\n   ";
    public static final String NINE  = " _ \n|_|\n _|\n   ";
    public static final String ZERO  = " _ \n| |\n|_|\n   ";
    
    public static String toDigit(String text) {
        switch(text) {
            case ONE:   return "1";
            case TWO:   return "2";
            case THREE: return "3";
            case FOUR:  return "4";
            case FIVE:  return "5";
            case SIX:   return "6";
            case SEVEN: return "7";
            case EIGHT: return "8";
            case NINE:  return "9";
            case ZERO:  return "0";
            default:    return "?";
        }        
    }
}
