package com.moodanalyzer.test;

import com.moodanalyzer.main.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    //TC-1.1
    @Test
    public void givenMood_WhenSadMessage_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Sad",analyzer.analyzeMood("I Am In Sad Mood"));
    }

    //TC-1.2
    @Test
    public void givenMood_WhenAnyMessage_ShouldReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Happy",analyzer.analyzeMood("I Am In Any Mood"));
    }

    //REFACTORED-1.1
    @Test
    public void givenMood_WhenSadMessageConstructor_ShouldReturnSad() {
        MoodAnalyzer analyzer = new MoodAnalyzer("I Am In Sad Mood");
        Assert.assertEquals("Sad",analyzer.analyzeMood());
    }
}
