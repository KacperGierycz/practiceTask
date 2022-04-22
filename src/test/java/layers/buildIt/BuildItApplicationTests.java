package layers.buildIt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;


@SpringBootTest
class BuildItApplicationTests {


BlockDatabase DataBaseMock = mock(BlockDatabase.class);
	
	@Test
	void getColorAndMaterialFromBlockTest() {
		
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		BlockImpl rb=DataBaseMock.getBlock();
		assertEquals("red",rb.getColor());
		assertEquals("brick",rb.getMaterial());
	}
	
	@Test
	public void getCompositeBlockSizeOfBlockListTest() {
		
		 when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		 BlockImpl rb=DataBaseMock.getBlock();
		 when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("white","wood"));
		 BlockImpl wb=DataBaseMock.getBlock();
		 
		List<BlockImpl> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);
		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		CompositeBlock bc=DataBaseMock.getCompositeBlock();
		assertEquals(2,bc.getBlocks().size());
	
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
