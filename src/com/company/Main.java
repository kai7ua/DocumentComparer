package com.company;

public class Main {

    public static void main(String[] args) {
        TextDocument doc1 = new TextDocument("Resources\\file1.txt");
        TextDocument doc2 = new TextDocument("Resources\\file2.txt");
        System.out.println("Comparing of doc1 and doc2:");
        System.out.format("doc1 in doc2: %.2f percents" , doc1.Compare(doc2));
        System.out.format("\ndoc2 in doc1: %.2f percents", doc2.Compare(doc1));
    }
}
