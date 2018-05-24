package com.slk.training.programs;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class P23_HashMapDemo {
	
	public static void main(String[] args) {
		
		Map<String, String> people = new TreeMap<>();
		people.put("Vinod", "vinod@vinod.co, 9731424784");
		people.put("Shyam", "shyamkc@gmail.com, 938373636");
		people.put("Vinod",  "kayartaya.vinod@gmail.com, 9844083934");
		people.put("vinod",  "kayartaya.vinod@gmail.com, 9844083934");
		people.put("Ajay",  "ajay@exmaple.com, 9844022224");
		people.put("David",  "david@exmaple.com, 9844022225");
		people.put("Ramesh",  "ramesh@exmaple.com, 9822022224");

		
		System.out.println("size = " + people.size());
		System.out.println("Distinct keys = " + people.keySet());
		System.out.println("Distinct values = " + people.values());
		
		System.out.println("Entries:");
		for(Entry<String, String> es: people.entrySet()) {
			System.out.println("Key = " + es.getKey() + ", value = " + es.getValue());
		}
		
		System.out.println("Vinod's data = " + people.get("Vinoda"));
		
		
	}

}
