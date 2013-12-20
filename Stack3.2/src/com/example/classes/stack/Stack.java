package com.example.classes.stack;

import java.util.LinkedList;
public class Stack {
	 private LinkedList<Object> stackList;
	 private int maxStack, stackNow;
	 public Stack(){
		stackList  = new LinkedList<Object>();
		maxStack = 10;
		stackNow = 0;
	 }
	 public Stack(int maxPlatesInStack){
		 maxStack = maxPlatesInStack;
		 stackNow = 0;
		 stackList = new LinkedList<Object>();
	 }
	 public Object pop(){
		 Object item = null;
		 if(stackNow == 0){
			 throw new IllegalArgumentException("The stack is empty");
		 }else{
			 item=stackList.pop();
			 stackNow--;
		 }	 
		 return item;
	 }
	 public void push(Object  item){
		 if(stackNow == maxStack){
			 throw new IllegalArgumentException("The stack is full");
		 }else{
			 stackList.addLast(item);
			 stackNow++;
		 }
	 }
	 
	 public void isEmpty(){
		if(stackList.isEmpty()){
			 throw new IllegalArgumentException("The stack is empty");
		}else{
			System.out.println("det finns plats i stacken");
		}
	}
}