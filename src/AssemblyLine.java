
public class AssemblyLine {

	

		public static void main(String[] args) {
			
		}
		
		
		//Si,j: the jth station on line i
		// ai,j: the assembly time required at station Si,j
		// ti,j: transfer time from station Si,j to the j+1 station of the other line.
		// ei (xi): time to enter (exit) line i
		
		public static int fastestWay(int entryTime[],int exitTime[], int processingTime[][], int transferTime[][], int noOfStations) throws IllegalArgumentException{
			
			if(entryTime.length != exitTime.length)
				throw new IllegalArgumentException("entry lines != exit lines ");
			
			
			int assemblyLines = entryTime.length;
			int f[][] = new int[assemblyLines][noOfStations];
			int trace[][] = new int[assemblyLines][noOfStations];
			int finalCost = 0;
			int finalLine = 0;
			
			
			for (int i = 0; i < assemblyLines; i++) 
				f[i][0] = entryTime[i]+processingTime[i][0];	//Get the first station time = entry plus first time
			
			
			for (int j = 1; j < noOfStations; j++) {
				
				if((f[0][j-1] + processingTime[0][j]) <= (f[1][j-1]+ transferTime[1][j-1]+processingTime[0][j])){
					f[0][j]= f[0][j-1]+ processingTime[0][j];
					trace[0][j] = 0;
				}else{
					f[0][j]= f[1][j-1]+ transferTime[1][j-1]+processingTime[0][j];
					trace[0][j]=1;
				}
				
				if(f[1][j-1] + processingTime[1][j] <= f[0][j-1]+ transferTime[0][j-1]+processingTime[1][j]){
					f[1][j]= f[1][j-1]+ processingTime[1][j];
					trace[1][j] = 1;
				}else{
					f[1][j]= f[0][j-1]+ transferTime[0][j-1]+processingTime[1][j];
					trace[1][j] = 0;
				}
				
			}
			
			if(f[0][noOfStations-1]+exitTime[0] <= f[1][noOfStations-1]+exitTime[1] ){
				finalCost =  f[0][noOfStations-1]+exitTime[0];
				finalLine = 0;
			}else{
				finalCost = f[1][noOfStations-1]+exitTime[1] ;
				finalLine = 1;
			}
			
			printStation(finalCost, finalLine, trace, noOfStations);
			return finalCost;
		}

		public static void printStation(int finalCost, int finalLine, int trace[][], int n){
			int i = finalLine;
			
			System.out.println("Assembly Line: "+(i+1)+" | Station: "+n);
			for (int j = n-1; j > 0; j--) {
		
				i = trace[i][j];
				System.out.println("Assembly Line: "+(i+1)+" | Station: "+(j));
				
			}
			System.out.println("Final Minimum Cost: "+ finalCost);
				
		}
}
