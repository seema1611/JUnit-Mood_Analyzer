package com.moodanalyzer.factory;

import com.moodanalyzer.exception.MoodAnalyzerException;
import com.moodanalyzer.main.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    private Class className;
    private String path;
    private String mood;
    public static MoodAnalyzer createMoodAnalyzer(Class className, String path, String mood) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyzerClass = Class.forName(path);
            Constructor<?> moodConstructor = moodAnalyzerClass.getConstructor(className);
            Object moodObj = moodConstructor.newInstance(mood);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_METHOD,e.getMessage());
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MoodAnalyzer createMoodAnalyzer(Class className, String path) throws MoodAnalyzerException {
        return createMoodAnalyzer(className,path,null);
    }
}

