package com.moodanalyzer.main;

public class MoodAnalyzer {

    public static String analyzeMood(String mood) {
        if (mood.contains("Sad"))
            return "Sad";
        else
            return "null";
    }
}
