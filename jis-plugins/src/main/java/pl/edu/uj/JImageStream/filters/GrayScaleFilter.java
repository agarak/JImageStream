package pl.edu.uj.JImageStream.filters;

import pl.edu.uj.JImageStream.api.core.Filter;
import pl.edu.uj.JImageStream.model.Pixel;

public class GrayScaleFilter extends Filter {
    @Override
    public void apply(int x, int y) {
        Pixel input = getPixel(x, y);
        int gray = (input.getRed() + input.getBlue() + input.getGreen()) / 3;
        setPixel(x, y, new Pixel(gray, gray, gray, 255));
    }
}