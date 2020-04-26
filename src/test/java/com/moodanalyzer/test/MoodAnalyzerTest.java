package com.moodanalyzer.test;

import com.moodanalyzer.exception.MoodAnalyzerException;
import com.moodanalyzer.main.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoodAnalyzerTest {

    //TC-1.1
    @Test
    public void givenMood_WhenSadMessage_ShouldReturnSad() throws MoodAnalyzerException {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Sad",analyzer.analyzeMood("I Am In Sad Mood"));
    }

    //TC-1.2
    @Test
    public void givenMood_WhenAnyMessage_ShouldReturnHappy()throws MoodAnalyzerException {
        MoodAnalyzer analyzer = new MoodAnalyzer();
        Assert.assertEquals("Happy",analyzer.analyzeMood("I Am In Any Mood"));
    }

    //REFACTORED-1.1
    @Test
    public void givenMood_WhenSadMessageConstructor_ShouldReturnSad() throws MoodAnalyzerException {
        MoodAnalyzer analyzer = new MoodAnalyzer("I Am In Sad Mood");
        Assert.assertEquals("Sad",analyzer.analyzeMood());
    }

    //REFACTORED-1.2
    @Test
    public void givenMood_WhenAnyMessageConstructor_ShouldReturnHappy() throws MoodAnalyzerException {
        MoodAnalyzer analyzer = new MoodAnalyzer("I Am In Any Mood");
        Assert.assertEquals("Happy",analyzer.analyzeMood());
    }

    //TC-2.1
    @Test
    public void givenMoodMessage_WhenNullMessage_ShouldReturnReturnHappy() {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",analyzer.analyzeMood());
    }

    //TC-3.1
    @Test
    public void givenMood_WhenNullMessage_ShouldReturnReturnHappy() {
        try {
            MoodAnalyzer analyzer = new MoodAnalyzer(null);
        } catch (MoodAnalyzerException e)
        {
            assertEquals(MoodAnalyzerException.ExceptionType.NULL,e.type);
        }
    }
}
