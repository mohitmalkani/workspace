package practicePackage;

class ArraySel
{
private long[] a; // reference to array a
private int nElems; // number of data items
//--------------------------------------------------------------
public ArraySel(int max) // constructor
{
a = new long[max]; // create the array
nElems = 0; // no items yet
}
//--------------------------------------------------------------
public void insert(long value) // put element into array
{
a[nElems] = value; // insert it
nElems++; // increment size
}
//--------------------------------------------------------------
public void display() // displays array contents
{
for(int j=0; j<nElems; j++) // for each element,
System.out.print(a[j] + " "); // display it
System.out.println(" ");
}
//--------------------------------------------------------------
public void selectionSort(){
	int out, in, min;
	for(out=0; out<nElems-1; out++){ //outer loop
	min=out;
		for(in=out+1; in<nElems;in++)
			if (a[in]<a[min])
				min=in;
				swap(out, min);
	}//end for
}// end selectionSort()
//--------------------------------------------------------------
private void swap(int one, int two)
{
long temp = a[one];
a[one] = a[two];
a[two] = temp;
}
//--------------------------------------------------------------
} // end class ArraySel

////////////////////////////////////////////////////////////////

class SelectionSortApp
{
public static void main(String[] args)
{ 
System.out.println("\n**Selection Sort**\n");
int maxSize = 100; // array size
ArraySel arr; // reference to array
arr = new ArraySel(maxSize); // create the array
arr.insert(77); // insert 10 items
arr.insert(99);
arr.insert(44);
arr.insert(55);
arr.insert(22);
arr.insert(88);
arr.insert(11);
arr.insert(00);
arr.insert(66);
arr.insert(33);
arr.display(); // display items
arr.selectionSort(); // selection sort them
arr.display(); // display them again
} // end main()
} // end class BubbleSortApp
////////////////////////////////////////////////////////////////