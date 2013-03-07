package practicePackage;

public class ClassDataApp {
	public static void main(String[] args)
	{
	int maxSize = 15; // array size
	ClassDataArray arr; // reference to array
	arr = new ClassDataArray(maxSize); // create the array
	// insert 10 items
	arr.insert("Evans", "Patty", 24);
	arr.insert("Smith", "Lorraine", 37);
	arr.insert("Yee", "Tom", 43);
	arr.insert("Adams", "Henry", 63);
	arr.insert("Hashimoto", "Sato", 21);
	arr.insert("Stimson", "Henry", 29);
	arr.insert("Velasquez", "Jose", 72);
	arr.insert("Lamarque", "Henry", 54);
	arr.insert("Vang", "Minh", 22);
	arr.insert("Creswell", "Lucinda", 18);
	arr.displayA(); // display items
	String searchKey = "Malkani"; // search for item
	Person found;
	
	found=arr.find(searchKey);
	if(found != null)
	{
		System.out.print("Found ");
		found.displayPerson();
	}
	else
		System.out.println("\n\nCan’t find: " + searchKey);
		System.out.println("\n\nDeleting Smith, Yee, and Creswell");
		arr.delete("Smith"); // delete 3 items
		arr.delete("Yee");
		arr.delete("Creswell");
		arr.delete("Malkani");
		arr.displayA(); // display items again
	} // end main()
} // end class ClassDataApp