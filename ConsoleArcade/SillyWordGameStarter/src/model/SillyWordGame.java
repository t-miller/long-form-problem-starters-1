package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SillyWordGame implements Iterable<Phrase> {

    private List<Phrase> phrases;
    private List<Phrase> phrasesNeeded;

    public SillyWordGame(List<Phrase> phrases) {
        this.phrases = phrases;
        this.phrasesNeeded = new ArrayList<>();
        for(Phrase p : phrases) {
            if (p.needsWord())
                phrasesNeeded.add(p);
        }
    }

    //EFFECTS: returns all phrases in this game
    public List<Phrase> getAllPhrases() {
        return phrases;
    }

    @Override
    public Iterator<Phrase> iterator() {
        return new SillyWordGameIterator();
    }

    private class SillyWordGameIterator implements Iterator<Phrase> {
        Iterator phrasesNeededIterator = phrasesNeeded.iterator();

        @Override
        public boolean hasNext() {
            return phrasesNeededIterator.hasNext();
        }

        @Override
        public Phrase next() {
            Phrase phrase = null;
            if (phrasesNeededIterator.hasNext()) {
                phrase = (Phrase) phrasesNeededIterator.next();
                phrasesNeeded.remove(phrase);
            }
            return phrase;
        }
    }
}
