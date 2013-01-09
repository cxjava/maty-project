package common;

import java.io.IOException;
import java.sql.SQLException;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ranges;
import com.google.common.io.InputSupplier;
import com.google.common.primitives.Ints;

public class Guava {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
		System.out.println(Objects.equal("a", "a")); // returns true
		System.out.println(Objects.equal(null, "a")); // returns false
		System.out.println(Objects.equal("a", null)); // returns false
		System.out.println(Objects.equal(null, null)); // returns true
		System.out.println(Objects.equal(1.2, 1.2)); // returns true
		System.out.println(Ints.compare(1, 1)); // returns true
		System.out.println(Ints.compare(1, 2)); // returns true
		int[] numbers = { 1, 2, 3, 4, 5 };  
		String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));  
		System.out.println(numbersAsString);
		ImmutableMap<String, Integer> map = ImmutableMap.of(  
			    "1", 1,  
			    "2", 2,  
			    "3", 3  
			);  
		
		ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);  
	}

}
