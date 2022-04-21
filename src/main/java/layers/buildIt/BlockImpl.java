package layers.buildIt;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class BlockImpl implements Block {
	
	private String color;
	private String material;
	
	BlockImpl(){}

	public BlockImpl(String color, String material){
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
