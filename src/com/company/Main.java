package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
    Laboratory work 1
    Copyright --- Kateryna Basova KNHUE
*/
public class Main {

    public static void main(String[] args) throws IOException {

        // get text from the file
        String text = new String(Files.readAllBytes(Paths.get("/home/kate/Documents/harry.txt")));
        // get all words from the text
        String[] allWords = text
                        .toLowerCase()
                        .replaceAll("[\\s\\.\\?\\!,\\-\":;]+", " ")
                        .split("\\s+");

        String longestWord = "";

        // find the longest word by comparing it with all words
        for (String word : allWords) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("1. The longest word in the text: " + longestWord);

        String[] lines = text.split("\n");
        int linesWithHarry = 0;

        // find number of lines with word "Harry"
        for (String line : lines) {
            if (line.contains("Harry")) {
                linesWithHarry++;
            }
        }

        System.out.println("2. Number of lines where the word \"Harry\" is met: " + linesWithHarry);

        String uniqueWords = "";
        String wordsWithIntersections = "";
        String hashesString = "";

        // If uniqueWords doesn't contain a word - its unique.
        // Otherwise: its an intersection. To avoid addition the word several times,
        // check if wordsWithIntersections already contains intersected word
        for (String word : allWords) {
            if (uniqueWords.contains(word) && !wordsWithIntersections.contains(word)) {
                wordsWithIntersections += word + " ";
            } else if (!uniqueWords.contains(word)) {
                uniqueWords += word + " "; // add words to uniqueWords if it's first occurrence
                hashesString += word.hashCode() + " ";
            }
        }

        String[] uniqueWordsArray = uniqueWords.split(" ");
        String[] hashesArray = hashesString.split(" ");

        System.out.println("3. Array of distinct words: ");
        for (String word : uniqueWordsArray) {
            System.out.println(word);
        }

        System.out.println("Array of distinct words hashes: ");
        for (String hash : hashesArray) {
            System.out.println(hash);
        }

        int countWords = wordsWithIntersections.split(" ").length;

        System.out.println("4. Number of words with intersections: " + countWords);

    }
}
