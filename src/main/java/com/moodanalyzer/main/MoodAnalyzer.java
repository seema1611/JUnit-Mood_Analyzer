package com.moodanalyzer.main;

public class MoodAnalyzer {

    public static String analyzeMood(String message) {
        if (message.contains("Sad"))
            return "Sad";
        else
            return "Happy";
    }
}
