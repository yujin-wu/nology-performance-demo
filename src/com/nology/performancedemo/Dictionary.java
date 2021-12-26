package com.nology.performancedemo;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {

    public static List<String> dictionaryList;

    public static Set<String> dictionarySet;

    public static void loadDictionary() {
        try {
            URL url = Dictionary.class.getResource("dictionary.txt");
            Path path = Paths.get(url.toURI());
            dictionaryList = Files.readAllLines(path, StandardCharsets.UTF_8);

            dictionarySet = new HashSet<>();

            for (String word : dictionaryList) {
                dictionarySet.add(word.toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isInDictionary(String word) { // O(1)
        return dictionarySet.contains(word.toLowerCase());
    }

    public static void main(String[] args) {
        // N = Number of words in dictionary, M = Number of words in the paragraph.
        loadDictionary();

        System.out.println(dictionaryList.size());

        long startTime = System.currentTimeMillis();

        // Task: Take a paragraph from input, and output all the misspelt words
        String paragraph = "Born in Cleveland, Ohio, Gage studied piano, musicology and literature at the University of Michigan and Yale, and later with Erik Werba at the Vienna Music Academy. He performed as a soloist, but above all was a collaborator with singers such as Elly Ameling, Arleen Auger, Walter Berry, Brigitte Fassbaender, Dietrich Fischer-Dieskau, Gundula Janowitz, Christa Ludwig, Edda Moser, Jessye Norman, Dagmar Pecková, Lucia Popp, Hermann Prey, Christine Schäfer, Peter Schreier. From his work with such international elite singers numerous award-winning recordings emerged.\n" +
                "\n" +
                "In 1970, he planned and accompanied an entire series of Lieder recitals at the Vienna Konzerthaus. From 1979 to 2005, Gage headed a song interpretation class at the Academy of Music and Theater in Zurich (now Zurich University of the Arts). In 2001, he was also appointed to a professorship for song interpretation at the Saarbrücken Music Academy, where he initiated a nationally unique program entitled \"Song Duo.\"\n" +
                "\n" +
                "Irwin Gage gave master classes in Europe, Japan, and the United States. He was a consultant and artistic director of concert series at various houses, including the Cologne Philharmonic. He sat on many juries for singing, song duo, chamber music, and solo piano at international music competitions.[2]";

        // make more words in the paragraph
        for (int i = 0; i < 5; i++) {
            paragraph += " " + paragraph;
        }


        String[] words = paragraph.split(" ");

        System.out.println("Number of words in paragraph: " + words.length);


        int misspeltWords = 0;
        for (String word : words) { // O(M)
            if (!isInDictionary(word)) {
                misspeltWords++;
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Duration: " + duration + " ms");

        System.out.println("Misspelt words: " + misspeltWords);
    }
}
