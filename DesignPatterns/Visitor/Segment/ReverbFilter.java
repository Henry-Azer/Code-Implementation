package DesignPatterns.Visitor.Segment;

public class ReverbFilter implements AudioFilter{
    @Override
    public void apply(FormatSegment formatSegment) {
        System.out.println("Add Reverb on Format Segment.");
    }

    @Override
    public void apply(FactSegment factSegment) {
        System.out.println("Add Reverb on Fact Segment.");
    }
}
