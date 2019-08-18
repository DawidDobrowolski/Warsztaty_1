package pl.coderslab.popularWords;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        String[] excludedWords = {"oraz", "albo", "jest", "dlatego", "które"};
        File file = new File("popular_words.txt");
        File file1 = new File("filtered_popular_words.txt");
        String site = "http://www.onet.pl/";

        String[] words = getStrings(site); //   loading the words
        Arrays.sort(words);                // sorting the word array
        createFile(file, words);           //   save file with words longer than 3 characters
        excludeWords(file, file1, excludedWords);    //   saving filtered words


    }


//    DOWNLOADING WORDS FROM THE WEBSITE TO THE STRING TABLE

    private static String[] getStrings(String site) {
        StringBuilder sb = new StringBuilder();
        Connection connect = Jsoup.connect(site);
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                sb.append(elem.text());
            }
        } catch (
                IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        return sb.toString().split(" ");
    }


//    FILE SAVING WITH LONGER WORDS THAN 3 CHARACTERS

    private static void createFile(File file, String[] words) {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (String word : words) {
                if (word.length() > 3) {
                    pw.println(word);
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    //    LOADING A FILE AND CHECKING KEYWORDS + SAVING A NEW FILE
    private static void excludeWords(File file, File newFile, String[] exWords) {
        String row;
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        loop1:
        while (scan.hasNextLine()) {
            row = scan.nextLine();
            loop2:
            for (String exWord : exWords) {
                if (row.equals(exWord)) {
                    continue loop1;
                }
            }
            pw.println(row);

        }
        pw.close();

    }
}