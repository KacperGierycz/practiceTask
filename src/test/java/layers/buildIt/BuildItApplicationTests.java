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


@Value("red")
private String color1;


@Value("Rasin")
private String material1;

@Value("${block.color}")
private String color2;

@Value("${block.material}")
private String material2;


//@Autowired
//BlockDatabase blockDatabase;

//private BlockImpl redBrick=blockDatabase.getRedBrick();

//BlockImpl blockImpl=new BlockImpl(color1,material1);

BlockDatabase DataBaseMock = mock(BlockDatabase.class);
	
	@Test
	void contextLoads() {
		
		System.out.println(color1);
		System.out.println(material1);
		System.out.println(color2);
		System.out.println(material2);
		
		
		
		
		ApplicationContext applicationContext=	SpringApplication.run(BuildItApplication.class);
		
		ContextTester contextT = applicationContext.getBean(ContextTester.class);
		
		BlockImpl blockImpl = applicationContext.getBean(BlockImpl.class);
		
		
		
	//	BlockImpl redBrick= applicationContext.getBean(redBrickInitializer.class);
		
		System.out.println(blockImpl.getColor());
		
		System.out.println(contextT.getName());
		

		
		when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		
		BlockImpl rb=DataBaseMock.getBlock();
		System.out.println(rb.getColor());
		
		 when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		
	}
	
	@Test
	public void getCompositeBlock() {
		
		 when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("red","brick"));
		 BlockImpl rb=DataBaseMock.getBlock();
		 when(DataBaseMock.getBlock()).thenReturn(new BlockImpl("white","wood"));
		 BlockImpl wb=DataBaseMock.getBlock();
		 
		List<BlockImpl> blockList=new ArrayList<>();
		blockList.add(rb);
		blockList.add(wb);
		System.out.println("From Composite block");
		System.out.println(rb.getColor());
		System.out.println(wb.getColor());
		when(DataBaseMock.getCompositeBlock()).thenReturn(new CompositeBlockImpl(blockList));
		
		System.out.println(DataBaseMock.getCompositeBlock());
	
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
