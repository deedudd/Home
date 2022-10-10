package maven.Home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class javaprac {
	@Test
	public void sample() {
		String s = "deepika";
		char[] arr = s.toCharArray();
		int cnt=1;
		for(int i=0;i<s.length();i++) {
			cnt=1;
			for(int j=i+1;j<s.length();j++) {
				if(arr[i]==arr[j]) {
					cnt++;
					arr[j]=' ';
				}
				
			}
			if(cnt==1 && arr[i]!=' ') {
				System.out.println(arr[i]);
			}
		}
		List<Character> lst = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			lst.add(arr[i]);
		}
		
		List<Character> arrChar = new ArrayList<>();
		
		List<Character> newArr = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
		if(!newArr.contains(arrChar.get(i))){
			newArr.add(arrChar.get(i));
		}}
		
		Set<Character> set = new HashSet<Character>(lst);
		 List<Character>list2 = new ArrayList<Character>(set);
		 System.out.println(list2);
}
	@Test
	public void method2() throws IOException {
		java2  j2 = new java2();
	//System.out.println(Arrays.toString(j2.method1()));
	}
}