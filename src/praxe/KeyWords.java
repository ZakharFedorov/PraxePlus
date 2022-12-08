package praxe;

/**
 *
 * @author Zakhar Fedorov
 */
public class KeyWords {
    
    private String word;
    private String topic;
    private int rok;

    public KeyWords(String word, String topic, int rok) {
        this.word = word;
        this.topic = topic;
        this.rok = rok;
    }
    
    public KeyWords(KeyWords w) {
        this.word = w.word;
        this.topic = w.topic;
        this.rok = w.rok;
    }

    public KeyWords() {
    }

    public String getWord() {
        return word;
    }

    public String getTopic() {
        return topic;
    }

    public int getRok() {
        return rok;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    @Override
    public String toString() {
        return "KeyWords{" + "word=" + word + ", topic=" + topic + ", rok=" + rok + '}';
    }
    
    
    
    
}

