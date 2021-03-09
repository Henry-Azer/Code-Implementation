package DesignPatterns.Visitor.Segment;

public class NoiseReductionFilter implements AudioFilter {
    @Override
    public void apply(FormatSegment formatSegment) {
        System.out.println("Reduce noise on Format Segment.");
    }

    @Override
    public void apply(FactSegment factSegment) {
        System.out.println("Reduce noise on Fact Segment.");
    }

}
