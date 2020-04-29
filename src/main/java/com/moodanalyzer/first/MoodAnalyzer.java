package com.moodanalyzer.first;

import com.moodanalyzer.exception.MoodAnalyzerException;

import java.util.Objects;

public class MoodAnalyzer {
    String message;

    //Default Constructor
    public MoodAnalyzer() {

    }

    //Parameterized constructor and pass string parameter
    public MoodAnalyzer(String message) {
        this.message=message;
    }

    //Paramerized method
    public static String analyzeMood(String message) throws MoodAnalyzerException {
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
    public String analyzeMood() throws MoodAnalyzerException {
        return analyzeMood(this.message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
            return false;
        MoodAnalyzer that=(MoodAnalyzer)obj;
        return Objects.equals(message,that.message);
    }

    //Main method
    public static void main(String args[]) {
        System.out.println("Welcome to mood analyzer");
    }
}