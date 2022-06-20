package E02Exam19february2022;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01foodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]words = new String[]{"pear","flour","pork","olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        //we hold the vowels
        ArrayDeque<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e->vowels.offer(e.charAt(0)));

        //we hold the consonants
        ArrayDeque<Character> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e->consonants.offer(e.charAt(0)));


        while (!consonants.isEmpty()){
            //we take the first vowel and the last consonant
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i]; // we take the word

                int indexVowel = word.indexOf(vowel); // we take the index of vowel
                int indexConsonant = word.indexOf(consonant);// we take the index of consonant

                if (indexVowel >= 0){
                    //we replace the * with the vowel we found
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0){
                    //we replace the * with the consonant we found
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowels.offer(vowel);
        }
        //we then make a list output which deletes everything except the words we found
        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());
        System.out.printf("Words found: %d%n",output.size());
        output.forEach(System.out::println);
    }
}
