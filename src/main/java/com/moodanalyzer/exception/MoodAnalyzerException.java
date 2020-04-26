package com.moodanalyzer.exception;

public class MoodAnalyzerException extends RuntimeException
{
    public enum ExceptionType
    {
        NULL,EMPTY
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
