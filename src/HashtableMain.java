
public class HashtableMain {
	public static int wordFrequency(String sentence) {
        MyHashTable<String, Integer> frequencyMap = new MyHashTable<>();
        String[] words = sentence.toLowerCase().split(" ");

        for (String word : words) {
            Integer frequency = frequencyMap.get(word);
            frequencyMap.add(word, (frequency == null) ? 1 : frequency + 1);
        }

        System.out.println("Word Frequencies:");
        for (String word : words) {
            System.out.println(word + ": " + frequencyMap.get(word));
        }

        return frequencyMap.size();
    }
	public static String removeWord(String sentence, String wordToRemove) {
        MyHashTable<String, Integer> frequencyMap = new MyHashTable<>();
        String[] words = sentence.toLowerCase().split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            Integer frequency = frequencyMap.get(word);
            frequencyMap.add(word, (frequency == null) ? 1 : frequency + 1);
        }

        frequencyMap.remove(wordToRemove);

        for (String word : words) {
            if (frequencyMap.get(word) != null) {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

	public static void main(String[] args) {
		String sentence1 = "To be or not to be";
        System.out.println("Sentence 1 Unique Words: " + wordFrequency(sentence1));
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        System.out.println("\nParagraph Unique Words: " + wordFrequency(paragraph));
        String modifiedParagraph = removeWord(paragraph, "avoidable");
        System.out.println("\nParagraph after removing 'avoidable':");
        System.out.println(modifiedParagraph);
	}

}
