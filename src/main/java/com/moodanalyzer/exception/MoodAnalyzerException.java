package com.moodanalyzer.exception;

import javafx.scene.image.Image;

public class MoodAnalyzerException extends Exception
{
    public enum ExceptionType
    {
        NULL,EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD,METHOD_INVOCATION_ISSUE,NO_SUCH_FIELD
    }
    public ExceptionType type;
    public MoodAnalyzerException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
    public MoodAnalyzerException(String message)
    {
        super(message);
    }
}
