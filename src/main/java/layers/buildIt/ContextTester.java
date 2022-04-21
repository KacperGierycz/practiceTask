package layers.buildIt;

import org.springframework.stereotype.Component;

@Component
public class ContextTester {

	private String name="The Name";
	
	public String getName() {
		return this.name;
	}
	
}
