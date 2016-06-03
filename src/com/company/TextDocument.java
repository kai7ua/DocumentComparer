package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TextDocument {
    private Set<String> words = null;
    private final String SPLITTERS = "[,./\\(\\)\\s:;!?-]";

    public TextDocument(String path) {
        words = new HashSet<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line = null;
            while ((line = bf.readLine()) != null) {
                for (String word : line.toLowerCase().split(SPLITTERS)) {
                    if (!word.isEmpty())
                        words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("This file1.txt doesn't exist.");
        } catch (IOException e) {
            System.out.println("Can't read file1.txt.");
        }
    }

    public Set<String> getWords() {
        return words;
    }

    public double Compare(TextDocument textDocument) {
        int counter = 0;
        for (String word : words) {
            for (String anotherWord : textDocument.words) {
                if (word.equals(anotherWord))
                    counter += 1;
            }
        }

        return 100 * (double) counter / textDocument.words.size();
    }
}
