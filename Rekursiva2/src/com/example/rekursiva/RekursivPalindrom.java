package com.example.rekursiva;
import java.io.*;
import java.util.*;

class RekursivPalindrom {
	public static void main(String [] args) {
		String mening = "N TaLAR BRA LATIN";
		mening=mening.replaceAll("\\s+","");
		mening=mening.toLowerCase();
		int palindrom = Palindrom(mening);
		System.out.println(palindrom);
	}



	
	public static int Palindrom (String mening){
		if(mening.length() == 0 || mening.length() == 1){
            return 1;
		}
        if(mening.charAt(0) == mening.charAt(mening.length()-1)){
            return Palindrom(mening.substring(1, mening.length()-1));
        }
        return 0;
	}
}