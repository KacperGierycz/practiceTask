package layers.buildIt;

import org.springframework.stereotype.Component;

@Component
public class BlockImpl implements Block {
	
	private String color;
	private String material;

	BlockImpl(String color,String material){
		this.color=color;
		this.material=material;
	}
	
	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public String getMaterial() {
		return this.material;
	}

}
