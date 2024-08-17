package HOMEWORK;

public class WordFrequencyCounter {

	public static void main(String[] args) {
        Text<Word> text = new Text<Word>();
        Dictionary<Word> dictionary = new Dictionary<Word>();
        FileIO.readTextFromFile(text,dictionary);

        RareWordsDictionary<Word> rareWordsDictionary = new RareWordsDictionary<Word>();
        FrequentWordsDictionary<Word> frequentWordsDictionary = new FrequentWordsDictionary<Word>();
        MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary = new MostFrequentWordsDictionary<Word>();
        text.separate(dictionary,rareWordsDictionary,frequentWordsDictionary,mostFrequentWordsDictionary);//It categorizes words based on their frequency.
        //Output:
        System.out.println("Text: ");
        System.out.println("Number of words: " + text.getCurrentSize());
        System.out.print("Content: ");
        text.displayItems();
        System.out.println();
        System.out.println("Rare Words Dictionary: ");
        System.out.println("Number of words: " + rareWordsDictionary.getCurrentSize());
        System.out.print("Content: ");
        rareWordsDictionary.displayItems();
        System.out.println();
        System.out.println("Frequent Words Dictionary: ");
        System.out.println("Number of words: " + frequentWordsDictionary.getCurrentSize());
        System.out.print("Content: ");
        frequentWordsDictionary.displayItems();
        System.out.println();
        System.out.println("Most Frequent Words Dictionary: ");
        System.out.println("Number of words: " + mostFrequentWordsDictionary.getCurrentSize());
        System.out.print("Content: ");
        mostFrequentWordsDictionary.displayItems();


    }

}
