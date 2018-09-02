package telran.imagga.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ImageColors {
	Color[] image_colors;
	Color[] background_colors;
    Color[] foreground_colors;

	public Color[] getImage_colors() {
		return image_colors;
	}

	public Color[] getBackground_colors() {
		return background_colors;
	}

	public Color[] getForeground_colors() {
		return foreground_colors;
	}
	
	@JsonIgnore
	public List<Color> getListOfCollors(){
		List<Color> res = new ArrayList<>(Arrays.asList(image_colors));
		res.addAll(Arrays.asList(foreground_colors));
		res.addAll(Arrays.asList(background_colors));
		return res;
				
	}

	

}
