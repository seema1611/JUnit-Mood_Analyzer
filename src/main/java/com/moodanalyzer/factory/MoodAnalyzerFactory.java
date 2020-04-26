package com.moodanalyzer.factory;

import com.moodanalyzer.exception.MoodAnalyzerException;
import com.moodanalyzer.main.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzer(Class className, String path, String mood) throws MoodAnalyzerException {
        try {
            Class<?> moodAnalyserClass = Class.forName(path);
            Constructor<?> moodConstructor = moodAnalyserClass.getConstructor(className);
            Object moodObj = moodConstructor.newInstance(mood);
            return (MoodAnalyzer) moodObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_CLASS,e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

