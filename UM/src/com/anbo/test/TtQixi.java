package com.anbo.test;

import java.util.*;
/**
 * 求数组的差集
 * @author liuxueping
 *
 */
public class TtQixi {
    public static void main(String[] args) {
		int a[]={5,2,8};
		int b[]={2,8,10,3,8};
		List<Integer> a1=new ArrayList<Integer>();
		List<Integer> history=new ArrayList<Integer>();//记录被删除的元素
		for(int i:a){
			
			if(!a1.contains(i)){
				a1.add(i);
				
			}
		}
		System.out.println(a1.toString());
		
		for(int i=0;i<b.length;i++){
			if(a1.contains(b[i])){
				System.out.println("b== "+b[i]);
				history.add(b[i]);
				a1.remove(a1.indexOf(b[i]));
				System.out.println("a1 "+a1.toString());
			}else{
				if(!history.contains(b[i])){
					System.out.println("no "+b[i]);
					a1.add(b[i]);
				}
				
			}
			   
		}
		for(int j:a1){
			System.out.println(j);
		}
	}
}
