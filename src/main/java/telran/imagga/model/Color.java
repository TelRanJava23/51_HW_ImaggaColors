package telran.imagga.model;

import java.util.Optional;

public class Color {
	String closest_palette_color_parent;
	String closest_palette_color;
	Double percent;
	Double percentage;

	public String getClosest_palette_color_parent() {
		return closest_palette_color_parent;
	}

	public String getClosest_palette_color() {
		return closest_palette_color;
	}

	public Double getPercent() {
		return percent;
	}

	public Double getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		Optional<Double> res = Optional.ofNullable(percent);
		return closest_palette_color + "\t\t" + closest_palette_color_parent + "\t" + res.orElse(percentage);
	}
}
