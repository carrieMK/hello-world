package info.rue.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws Exception {    	
    	Scanner sc = new Scanner(System.in);
    	int count = 0;
    	try {
        	count = sc.nextInt();
    	} catch(InputMismatchException ime) {
    		ime.printStackTrace();
    		throw ime;
    	} catch(Exception e) {
    		e.printStackTrace();
    		throw e;
    	} finally {
    		sc.close();
    	}
    	
    	App app = new App();    	
		ArrayList<TreeSet<Integer>> lottoNum = new ArrayList<TreeSet<Integer>>();
    	TreeSet<Integer> lottoPic = new TreeSet<Integer>();	    	
    	lottoNum = app.lottoNumber(count);
    	lottoPic = app.lottoNumber2(lottoNum);
    	    	
    	for(int i = 0; i < lottoNum.size(); i++) {
    		app.SetPrint(lottoNum.get(i));
    	}
    	System.out.println("--------------------");
    	app.SetPrint(lottoPic);
    }
    
    
    private ArrayList<TreeSet<Integer>> lottoNumber(int n) {  	
		ArrayList<TreeSet<Integer>> treeArray = new ArrayList<TreeSet<Integer>>();		
    	for(int i = 0; i < n; i++) {
    		TreeSet<Integer> set = new TreeSet<Integer>();	
    		while(set.size() < 6) {
    			set.add((int)(Math.random()*45) + 1);
    		}
    		treeArray.add(set);
    	}    	
		return treeArray;
    }    
    
    private TreeSet<Integer> lottoNumber2(ArrayList<TreeSet<Integer>> t) {
    	ArrayList<Integer> numAll = new ArrayList<Integer>();
    	TreeSet<Integer> set = new TreeSet<Integer>();     	
    	for (int i = 0; i < t.size(); i++) {
    		numAll.addAll(t.get(i));
    	}   	
    	
    	Collections.shuffle(numAll);    	
    	for(int i = 0; i < 6; i++) {
    		set.add(numAll.get(i));
    	}    	
		return set;
    }
    
    private void SetPrint(TreeSet<Integer> set) {
    	Iterator<Integer> itr = set.iterator();    	
    	while(itr.hasNext()) {
    		int i = itr.next();
    		System.out.print(i + "  ");
    	}
    	System.out.println("");
    }
}
