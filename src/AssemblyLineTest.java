import static org.junit.Assert.*;

import org.junit.Test;

public class AssemblyLineTest {

		@Test
	public void test() {
		/*int entryTime[] = {2,4};
		int exitTime[] = {3,2};
		int processingTime[][]={{7,9,3,4,8,4},{8,5,6,4,5,7}};
		int transferTime[][]={{2,3,1,3,4},{2,1,2,2,1}};
		int noOfStations = 6;
		int actualMinCost = 38;
		int expMinCost = 0;*/
		
		int entryTime[] = {1,3};
		int exitTime[] = {3,3};
		int processingTime[][]={{5,7,5},{8,4,6}};
		int transferTime[][]={{1,3},{2,2}};
		int noOfStations = 3;
		int actualMinCost = 20;
		int expMinCost = 0;
		
		expMinCost = AssemblyLine.fastestWay(entryTime,exitTime,processingTime,transferTime,noOfStations);
		
		if(expMinCost != actualMinCost)
			fail("Test case fails. actual cost is not equal to calculated cost.");

	}

}
