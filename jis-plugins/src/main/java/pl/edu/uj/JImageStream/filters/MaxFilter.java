package pl.edu.uj.JImageStream.filters;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import pl.edu.uj.JImageStream.api.core.Filter;
import pl.edu.uj.JImageStream.model.Pixel;

/**
 * Created by kuba on 2016-11-13.
 */
public class MaxFilter extends Filter {

    public MaxFilter() {
        maskSize = 3;
    }

    public MaxFilter(int maskSize) {
        this.maskSize = maskSize;
    }

    private int maskSize;

    @Override
    public void apply(int x, int y) {
        List<Pixel> pixelList = new ArrayList<>();

        for (int i = -maskSize / 2; i <= maskSize / 2; ++i) {
            for (int j = -maskSize / 2; j <= maskSize / 2; ++j) {
                try {
                    pixelList.add(getPixel(x + i, y + j));
                } catch (Exception e) {
                    //corner case, no need to handle
                }
            }
        }

        Integer red = pixelList.stream().map(Pixel::getRed).sorted().max(Comparator.naturalOrder()).get();
        Integer green = pixelList.stream().map(Pixel::getGreen).sorted().max(Comparator.naturalOrder()).get();
        Integer blue = pixelList.stream().map(Pixel::getBlue).sorted().max(Comparator.naturalOrder()).get();
        Integer alpha = pixelList.stream().map(Pixel::getAlpha).sorted().max(Comparator.naturalOrder()).get();

        setPixel(x, y, new Pixel(red, green, blue, alpha));
    }


}
