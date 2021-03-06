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
		 
		List<Block> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);
		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		CompositeBlock bc=DataBaseMock.getCompositeBlock();
		assertEquals(2,bc.getBlocks().size());
	
	}
	
	@Test
	public void wallConstructorTest() {
		
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		BlockImpl rb=DataBaseMock.getBlock();
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("white","wood"));
		BlockImpl wb=DataBaseMock.getBlock();
		 
		List<Block> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);

		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		CompositeBlock bc=DataBaseMock.getCompositeBlock();

		List<Block> blockListWithComposite=new ArrayList<>();
		blockListWithComposite.add(rb);
		blockListWithComposite.add(wb);
		blockListWithComposite.add(bc);
		when(DataBaseMock.getWall()).thenReturn(new Wall(blockListWithComposite));
		Wall wall=DataBaseMock.getWall();
		assertEquals(3,wall.count());
		
	}
	
	@Test
	public void getColorNoCompositeTest() {
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		BlockImpl rb=DataBaseMock.getBlock();
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("white","wood"));
		BlockImpl wb=DataBaseMock.getBlock();
		 
		List<Block> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);
		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		CompositeBlock bc=DataBaseMock.getCompositeBlock();
		assertEquals("red, white",bc.getColor());
		}
		
	@Test
	public void getColorCompositeTest() {
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		BlockImpl rb=DataBaseMock.getBlock();
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("white","wood"));
		BlockImpl wb=DataBaseMock.getBlock();
		 
		List<Block> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);

		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		CompositeBlock bc=DataBaseMock.getCompositeBlock();

		List<Block> blockListWithComposite=new ArrayList<>();
		blockListWithComposite.add(rb);
		blockListWithComposite.add(wb);
		blockListWithComposite.add(bc);
		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockListWithComposite));
		Block compositeBlock=DataBaseMock.getCompositeBlock();
		
		
		assertEquals("red, white, red, white",compositeBlock.getColor());
		
	}
	
}
