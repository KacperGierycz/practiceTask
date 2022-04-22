package layers.buildIt;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface BlockDatabase {
	
	BlockImpl getBlock();
	CompositeBlockImpl getCompositeBlock();
	Wall getWall();
	
}
