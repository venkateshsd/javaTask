package task2;
import java.util.*;
import java.io.*;
class stringSet {
	public int has=-1;
	public String getString() throws IOException{
		String userString;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your string:");
		userString = reader.readLine();
		return userString;
	}
	public void putsString(List stringList) {
		System.out.println("Elements in the StringSet:");
		if(stringList.isEmpty()){
			System.out.println("StringSet is empty!");
		}
		else {
			for(int index=0; index<stringList.size(); index++){
				System.out.println(stringList.get(index));
			}	
		}
	}
	public int hasString(List stringList,String inputString){
		String listElement;
		if(stringList.size()==0){
			stringList.add(inputString);
		}
		else {
			for(int index=0;index<stringList.size();index++){
				listElement = stringList.get(index).toString();
				if(listElement.equalsIgnoreCase(inputString)){
					System.out.println("Element '"+inputString+"' already present!");
					has = 1;
					index = stringList.size();
				}
				else{
					has = 0;
				}
			}
		}
		
		return has;
	}
	public void addString(List stringList,String inputString){
		int hasVal = hasString(stringList,inputString);
		if(hasVal==0){
			stringList.add(inputString);
			has=-1;
		}
		putsString(stringList);
	}
	public void deleteString(List stringList,String inputString){
		String listElement;
		for(int index=0;index<stringList.size();index++){
			listElement = stringList.get(index).toString();
			if(listElement.equalsIgnoreCase(inputString)){
				stringList.remove(index);
			}

		}
		putsString(stringList);
	}
}

public class task2 {
	public static void main(String args[])  throws IOException{
		int inputChoice = 0;
		String inputString;
		stringSet ss = new stringSet();
		List stringList = new ArrayList();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			System.out.println("1.Add String");
			System.out.println("2.Delete String");
			System.out.println("3.Exit Program");
			System.out.println("Enter your Option:");
			try{
				inputChoice = Integer.parseInt(reader.readLine());	
			}
			catch(Exception e){
				System.out.println("Enter a valid choice");
				continue;
			}
			switch(inputChoice) {
			case 1:
				inputString = ss.getString();
				ss.addString(stringList, inputString);
				break;
			case 2:
				inputString = ss.getString();
				ss.deleteString(stringList, inputString);
				break;
			case 3:
				System.out.println("Program Terminated");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
			
	}
}