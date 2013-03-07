package practicePackage;

class ClassDataArray {
	
	//public ClassDataApp data = new ClassDataApp();
	private Person[] a; // reference to array
	private int nElems; // number of data items
	public ClassDataArray(int max) // constructor
	{
		a = new Person[max]; // create the array
		nElems = 0; // no items yet
	}
	//--------------------------------------------------------------
	public Person find(String searchName)
	{ // find specified value
		int j;
		for(j=0; j<nElems; j++) // for each element,
			if( a[j].getLast().equals(searchName) ) // found item?
				break; // exit loop before end
			if(j == nElems) // gone to end?
				return null; // yes, can’t find it
		else
			return a[j]; // no, found it
	} // end find()
	
	
	//MOHIT START-------------------------------------------------------------
	public Person searchPerson(String lastNameSearch){
		int j;
		for(j=0; j<=nElems; j++){
			if(a[j].getLast().equals(lastNameSearch)){
				break;
			}
			if(j == nElems){
				return null; 
			}
		}
		return a[j];
	}
	//MOHIT END-------------------------------------------------------------
	
	
	//-------------------------------------------------------------
	// put person into array
	public void insert(String last, String first, int age)
	{
		a[nElems] = new Person(last, first, age);
		nElems++; // increment size
	}
	//--------------------------------------------------------------
	public boolean delete(String searchName)
	{ // delete person from array
		int j;
		for(j=0; j<nElems; j++) // look for it
			if( a[j].getLast().equals(searchName) )
				break;
		if(j==nElems){ // can’t find it
			System.out.println("\nCan't find this last name ");
			return false;
		}
		else // found it
		{
			for(int k=j; k<nElems; k++) // shift down
				a[k] = a[k+1];
			nElems--; // decrement size
			return true;
		}
	} // end delete()
	//--------------------------------------------------------------
	public void displayA() // displays array contents
	{
	for(int j=0; j<nElems; j++) // for each element,
	a[j].displayPerson(); // display it
	}
	//--------------------------------------------------------------
} // end class ClassDataArray

