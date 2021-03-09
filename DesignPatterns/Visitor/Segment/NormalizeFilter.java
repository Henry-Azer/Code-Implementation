package DesignPatterns.Visitor.Segment;

public class NormalizeFilter implements AudioFilter {
    @Override
    public void apply(FormatSegment formatSegment) {
        System.out.println("Normalize Filter on Format Segment.");
    }

    @Override
    public void apply(FactSegment factSegment) {
        System.out.println("Normalize Filter on Fact Segment.");
    }
}
