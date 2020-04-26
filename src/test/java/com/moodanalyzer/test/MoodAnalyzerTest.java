package com.moodanalyzer.test;

import com.moodanalyzer.main.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenMood_WhenSadMessage_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Sad",analyzer.analyzeMood("I Am In Sad Mood"));
    }

    @Test
    public void givenMood_WhenAnyMessage_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Happy",analyzer.analyzeMood("I Am In Any Mood"));
    }
}
