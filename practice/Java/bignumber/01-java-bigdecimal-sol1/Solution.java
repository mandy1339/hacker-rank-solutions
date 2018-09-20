package com.hackerrank.code1;

import java.math.BigDecimal;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Solution
{
	public static void main(String[] args){
	
		String[] arr1 = {"9","-100","50","0","56.6","90","0.12", ".12", "02.34","000.000"};
		String[] arr2 = Arrays.copyOf(arr1, arr1.length);
		PriorityQueue<Entry> heap = new PriorityQueue<Entry>(Collections.reverseOrder());

        for(int i=0;i<arr1.length;i++)
        {
            heap.add(new Entry(new BigDecimal(arr1[i]), arr1[i]));
        }
        int i = 0;
        while(!heap.isEmpty()) {
        	Entry entry= heap.poll();
        	arr2[i] = entry.getValue();
        	i++;
        }
        
        //Output
        for(int ind=0;ind<arr2.length;ind++)
        {
            System.out.println(arr2[ind]);
        }
	}
	
	
}



class Entry implements Comparable<Entry> {
    private BigDecimal key;
    private String value;

    public Entry(BigDecimal key, String value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public int compareTo(Entry other) {
        return this.getKey().compareTo(other.getKey());
    }

	public BigDecimal getKey() {
		return key;
	}

	public void setKey(BigDecimal key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}



