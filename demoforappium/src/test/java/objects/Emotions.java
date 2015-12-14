package objects;

public enum Emotions {
    
    ANGRY ("Angry5"),
    SATISFY ("Satisfy"),
    GOOD ("Good"),
    HAPPY("Happy");
        
    private final String text;

    private Emotions (final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }


}
