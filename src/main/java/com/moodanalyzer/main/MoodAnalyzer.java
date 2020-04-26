package com.moodanalyzer.main;

import com.moodanalyzer.exception.MoodAnalyzerException;

public class MoodAnalyzer {
    String message;

    //Default Constructor
    public MoodAnalyzer()
    {

    }

    //Parameterized constructor and pass string parameter
    public MoodAnalyzer(String message)
    {
        this.message=message;
    }

    //Paramerized method
    public String analyzeMood(String message) {
        try
        {
            if (message.isEmpty()) {
                throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.EMPTY,"Empty Message");
            }
            if (message.contains("Sad")) {
                return "Sad";
            } else
                return "Happy";
        } catch(NullPointerException e)
        {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NULL,"Null Message");
        }
    }

    //Default method
    public String analyzeMood() {
        return analyzeMood(this.message);
    }
}
