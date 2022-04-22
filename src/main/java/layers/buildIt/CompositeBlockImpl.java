package layers.buildIt;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CompositeBlockImpl implements CompositeBlock {
	
	private List<BlockImpl> blocks;
	
	CompositeBlockImpl(){}
	
	CompositeBlockImpl(List<BlockImpl> blocks){
		this.blocks=blocks;
	}
	

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMaterial() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getBlocks() {
		
		return this.blocks;
	}

}
