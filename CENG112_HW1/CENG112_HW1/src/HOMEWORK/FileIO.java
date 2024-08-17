package HOMEWORK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//FileIO class
public class FileIO {
    public static void readTextFromFile(Text<Word> text, Dictionary<Word> dictionary) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/homework/text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Replace punctuation
        String cleanedText = contentBuilder.toString().toLowerCase().replaceAll("[.,\"'\\\\]", "").replace("\n"," ").replace("ı","i");
        String[] document = cleanedText.split("\\s+");
        for(int i=0; i<document.length; i++){
            Word word = new Word(document[i]); //Create new word
            dictionary.add(word);
            text.add(word); //Add word to the text
        }

    }
}
