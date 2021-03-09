package DesignPatterns.Adapter.Image;

import DesignPatterns.Adapter.Image.Filters.Caramel;

public class CaramelAdapter extends Caramel implements Filter {
    @Override
    public void apply(Image image) {
        init();
        render(image);
    }
}
