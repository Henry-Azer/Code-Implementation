package DesignPatterns.Visitor.Segment;

public class FormatSegment extends Segment {
    @Override
    public void applyFilter(AudioFilter filter) {
        filter.apply(this);
    }
}
