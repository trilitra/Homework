package ru;

import com.sun.deploy.net.MessageHeader;

import java.util.Random;

/**
 *  * Задание 2. Создать генератор текстовых файлов, работающий по следующим правилам:
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее
 * предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class GeneratorApp {
    private static String[] randomWords;
    public static void main(String[] args) {
        String[] words = {"идея", "java", "программа", "учеба", "университет", "разработчик", "вероятность", "время"};
        getFiles("C:\\Users\\efano\\IdeaProjects\\Homework", 3, 1, words, 10);


    }

    private static void getFiles(String path, int n, int size, String[] words, int probability){
        getSentence(100);

    }
    private static String[] getSentence(Integer numberOfSentence){
        getWords(100);
        randomWords[randomWords.length - 1] = ",";
        String[] randomSentence = new String[numberOfSentence];
        Random random = new Random();
        for(int i = 0; i < numberOfSentence; i++)
        {
            String[] sentence = new String[random.nextInt(15)+1]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < sentence.length; j++)
            {
                sentence[j] = randomWords[random.nextInt(randomWords.length)];
            }
            for (int j = 0; j < sentence.length; j++) {
                randomSentence[i] =
            }
            randomSentence[i] = String.valueOf(sentence);

        }
        for (int j = 0; j <randomSentence.length ; j++) {
            System.out.println(String.valueOf(randomSentence));
        }
        return randomSentence;
    }

    private  static  String[] getWords(Integer numberOfWords){
        randomWords = new String[numberOfWords];
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(15)+1];
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomWords[i] = new String(word);
        }
        return randomWords;

    }
}
