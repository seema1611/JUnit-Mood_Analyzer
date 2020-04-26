package com.moodanalyzer.test;

import com.moodanalyzer.exception.MoodAnalyzerException;
import com.moodanalyzer.factory.MoodAnalyzerFactory;
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
    public void givenMoodMessage_WhenNullMessage_ShouldReturnReturnHappy() throws MoodAnalyzerException {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        Assert.assertEquals("Happy",analyzer.analyzeMood());
    }

    //TC-3.1
    @Test
    public void givenMood_whenNull_shouldReturnCustomMessage() {
        MoodAnalyzer analyzer = new MoodAnalyzer(null);
        try
        {
            analyzer.analyzeMood();
        } catch (MoodAnalyzerException e)
        {
            assertEquals(MoodAnalyzerException.ExceptionType.NULL,e.type);
        }
    }

    //TC-3.2
    @Test
    public void givenMood_whenEmpty_shouldReturnCustomMessage() {
        MoodAnalyzer analyzer= new MoodAnalyzer("");
        try
        {
            analyzer.analyzeMood();
        } catch (MoodAnalyzerException e)
        {
            assertEquals(MoodAnalyzerException.ExceptionType.EMPTY,e.type);
        }
    }

    //TC-4.1
    @Test
    public void givenMoodAnalyseClass_WhenProper_ShouldReturnObject() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyserFactoryObj = MoodAnalyzerFactory.createMoodAnalyzer(String.class,"com.moodanalyzer.main.MoodAnalyzer","I am In Happy Mood");
        Assert.assertEquals(moodAnalyserFactoryObj.analyzeMood(), MoodAnalyzer.analyzeMood("I am In Happy Mood"));
    }

    //TC-4.2
    @Test
    public void givenMoodAnalyseClass_WhenImproper_ShouldThrowException() throws MoodAnalyzerException {
        try
        {
            MoodAnalyzer  moodAnalyserFactoryObj = MoodAnalyzerFactory.createMoodAnalyzer(String.class,"", "I am In Happy Mood");
        }catch (MoodAnalyzerException e) {
            assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    //TC-4.3
    @Test
    public void givenMoodAnalyseMethod_WhenImproper_ShouldReturnException() throws MoodAnalyzerException {
        try {
            MoodAnalyzer  moodAnalyserFactoryObj = MoodAnalyzerFactory.createMoodAnalyzer(Integer.class, "com.moodanalyzer.main.MoodAnalyzer", "I am In Happy Mood");
        }catch (MoodAnalyzerException e) {
            assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    //TC-5.1
    @Test
    public void givenMoodAnalyseClassConstructor_WhenProper_ShouldReturnObject() throws MoodAnalyzerException {
        MoodAnalyzer moodAnalyserFactoryObj = MoodAnalyzerFactory.createMoodAnalyzer(String.class,"com.moodanalyzer.main.MoodAnalyzer");
        Assert.assertEquals(moodAnalyserFactoryObj.analyzeMood("I am In Happy Mood"), MoodAnalyzer.analyzeMood("I am In Happy Mood"));
    }

    //TC-5.2
    @Test
    public void givenMoodAnalyseClassConstructor_WhenImproper_ShouldThrowException() throws MoodAnalyzerException {
        try
        {
            MoodAnalyzer  moodAnalyserFactoryObj = MoodAnalyzerFactory.createMoodAnalyzer(String.class,"");
        }catch (MoodAnalyzerException e) {
            assertEquals(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }
}
