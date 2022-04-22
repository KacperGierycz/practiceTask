package layers.buildIt;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Wall implements Structure {
	
private List blocks;

public Wall() {}

public Wall(List<Block> blocks) {
	this.blocks=blocks;
}

@Override
public Optional findBlockByColor(String color) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List findBlocksByMaterial(String material) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public int count() {
	
	

	return blocks.size();
}
}

