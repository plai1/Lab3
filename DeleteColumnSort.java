// Import necessary packages to use the List
import java.util.ArrayList;
import java.util.List;


public class DeleteColumnSort{

	List<Integer> output = new ArrayList<Integer>(); //creates empty list of integers


	public boolean sameLength(String [] strlist){ //checks if each string in a list has the same length
		for(int i = 0; i < strlist.length-1; i++){
			if(strlist[i].length() != (strlist[i+1]).length())
				return false;
		}	
		return true;
	}

	public List<Integer> minDeletionSize(String [] strList){ //finds the columns that are not in ascending order, outputs a List
		if (sameLength(strList)){ //if all the strings have the same length
			for(int i = 0; i < strList.length - 1; i++){ //iterate through 
				for (int j = 0; j < (strList[0]).length(); j++){
					if((strList[i].charAt(j) > strList[i+1].charAt(j)) && (output.indexOf(j) == -1)){
						output.add(j);
					}
				}
			}
		} else{
			output.add(-1); //if each string have different lengths
		}
		return output; 
	}

	public static void main(String args[]){

		DeleteColumnSort find = new DeleteColumnSort();

		String [] words = {"abc", "def", "ghi", "jkl", "ecd"};

		List<Integer> results = find.minDeletionSize(words); //assigns List<Integers> results as answer

		System.out.print("{ "); //prints out every integer in the result list
		for(int i = 0; i < results.size(); i++){
			System.out.print(results.get(i) + " ");
			if (results.size() > 1 && i != results.size()-1)
				System.out.print(", ");
		}
		System.out.print("}");

	}
}
