package dsa;

public class HighArray {
	private long[] a;
	private int nElems;
	private long maxValue;

	// constructor	
	public HighArray(int max){
		a = new long[max];
		nElems = 0;
	}
	
	public boolean find(long searchKey){
		// find specified value
		int j;
		for(j=0; j<nElems; j++)
			// for each element,
			if(a[j] == searchKey)
				// found item?
				break;
			// exit loop before end
			if(j == nElems)
				// gone to end?
				return false;
			// yes, can’t find it
			else
				return true;
			// no, found it
	} // end find()
	
	// put element into array
	public void insert(long value){
		a[nElems] = value;
		// insert it
		nElems++;
		// increment size
	}
	
	public boolean delete(long value){
		int j;
		for(j=0; j<nElems; j++)
			// look for it
			if( value == a[j] )
				break;
			if(j==nElems)
				// can’t find it
				return false;
			else{
				// found it
				for(int k=j; k<nElems; k++) // move higher ones down
					a[k] = a[k+1];
					nElems--;
					// decrement size
				return true;
			}
	} // end delete()
	
	public void displayAnItem(long value){
		for(int j=0; j<nElems; j++){
			if( value == a[j] ){
				System.out.print(a[j] + " "); // display it
				System.out.println("");
			}else {
				System.out.println("Value " + value + " was not found!");
				break;
			}
		}
	}
	
	public long getMax(){
		for (int i = 1; i < a.length; i++ ){
			if (a[i-1] < a[i]){
				maxValue = a[i];
				return maxValue;
			}
		}
		return -1;
	} // end getMax()

	public boolean removeMax(long value){
		if( value == maxValue ){
			for(int j=0; j < a.length; j++){
				if (value == a[j]){
					a[j] = a[j+1];
					nElems--;
				}
			}
			System.out.println("Max Value Removed: " + value);
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args){
		int maxSize = 100;
		int searchKey = 35;
		
		HighArray arr = new HighArray(maxSize); // create the array
		
		arr.insert(21);
		arr.insert(19);
		arr.insert(17);
		arr.insert(15);
		arr.insert(39);
		arr.insert(21);
		
		long result = arr.getMax();
		
		if (result != -1){
			System.out.println("Max Value " + result);
		}
		
		arr.removeMax(result);
		arr.displayAnItem(result);
		
	}
} // end class HighArray