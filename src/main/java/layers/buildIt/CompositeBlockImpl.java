package layers.buildIt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CompositeBlockImpl implements CompositeBlock {
	
	private List<Block> blocks=new ArrayList<>();
	
	CompositeBlockImpl(){}
	
	CompositeBlockImpl(List<Block> blocks){
		this.blocks=blocks;
	}
	

	@Override
	public String getColor() {

		StringBuilder sb=new StringBuilder();

		Iterator blockIterator=blocks.iterator();
		while(blockIterator.hasNext()){
			Block blockColor=(Block) blockIterator.next();
			String color= blockColor.getColor();
			sb.append(color+", ");
		}
		
		sb.deleteCharAt(sb.length()-1);
		sb.deleteCharAt(sb.length()-1);
		
		return sb.toString();
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
	
	public void add(Block newBlock) {
		blocks.add(newBlock);
		}
	
	public Block getBlock(int blockIndex) {
		return blocks.get(blockIndex);
	}

}
