package Practise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashTest {
public static void main(String[] args) {
	
	//Define the HashMap
	HashMap<String , String> map = new HashMap<String, String>();
	//Adding some element to Hash Map
	map.put("Deeksha", "1");
	map.put("Sameeksha", "2");
	map.put("Shivika", "3");
	map.put("Dharmendra", "4");
	map.put("Ashok", "5");
	
	// get to know the size of hash map
	System.out.println("Size of MAP :" +map.size());
	
	//To Display the elements 
	
	System.out.println("The elements are :");
    Set set = map.keySet();
     
    Iterator keySetIterator = set.iterator();
   while (keySetIterator.hasNext()) 
  {
        Object key = keySetIterator.next();
        
      System.out.println(key+"  : "+map.get(key));
   }
}
	
}
