package HOMEWORK;
//Text Class
public class Text<Word> extends Bag<Word>{
    public void separate(Dictionary<Word> dictionary, RareWordsDictionary<Word> rareWordsDictionary,
                         FrequentWordsDictionary<Word> frequentWordsDictionary,
                         MostFrequentWordsDictionary<Word> mostFrequentWordsDictionary) {
        while (!dictionary.isEmpty()){ 
            Word word = dictionary.remove(); //Remove until there are no elements left in the bag and get the removed element(last element).
            int frequency = dictionary.getFrequencyOf(word)+1; // Since word removed from bag, it's frequency will be one missing. So we add 1 one to the result.
            if (frequency < 5) {
            	//Since sometimes we remove same element again and again, it's frequency decrease. 
            	//So, even an element is belongs to mostFrequentWordsDictionary, it will added rareWordsDictionary at some point.
            	//Thus, we prevent this. We also prevent same element repetition in a rareWordsDictionary
                if(!frequentWordsDictionary.contains(word) && !mostFrequentWordsDictionary.contains(word) && !rareWordsDictionary.contains(word)){
                    rareWordsDictionary.add(word);
                }
            } else if (frequency <= 8) {
            	//The reason for the control I did in the if statement is the same as the one above.
                if(!mostFrequentWordsDictionary.contains(word) && !frequentWordsDictionary.contains((word))){
                    frequentWordsDictionary.add(word);
                }

            } else {
            	//Prevent repetition of same element
                if(!mostFrequentWordsDictionary.contains(word)) {
                    mostFrequentWordsDictionary.add(word);
                }
            }
        }
    }
}
