package com.moodanalyzer.main;

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
        try {
            if (message.contains("Sad"))
                return "Sad";
            else
                return "Happy";
        }catch (NullPointerException e) {
            return "Happy";
        }
    }


    public String analyzeMood() {
        return analyzeMood(this.message);
    }
}
