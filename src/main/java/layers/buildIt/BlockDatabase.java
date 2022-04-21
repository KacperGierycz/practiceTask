package layers.buildIt;

import org.springframework.stereotype.Component;

@Component
public interface BlockDatabase {
	
	BlockImpl getBlock();
	
}
