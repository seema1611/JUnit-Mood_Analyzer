package com.moodanalyzer.factory;

import com.moodanalyzer.exception.MoodAnalyzerException;
import com.moodanalyzer.first.MoodAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    public static String Invoke(Class className, String path, String mood) throws MoodAnalyzerException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method m = MoodAnalyzer.class.getMethod("analyzeMood",String.class);
        Object value = m.invoke(new MoodAnalyzer(),mood);
        return (String) value;
    }

    public static String setFieldValue(MoodAnalyzer obj, String message, String fieldName) throws MoodAnalyzerException {
        try {
            Field field=obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj,message);
            return (String) obj.getClass().getDeclaredMethod("analyseMood").invoke(obj);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.NO_SUCH_FIELD,e.getMessage());
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.ExceptionType.METHOD_INVOCATION_ISSUE,e.getMessage());
        }
        return message;
    }
}
