import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
//wf1: contains all the words to check
	ArrayList<String> wf1=new ArrayList<String>();
		
//wf2: contains all the words in the dictionary
	ArrayList<String> wf2=new ArrayList<String>();
		
try {
	
 BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
   BufferedReader br2 = new BufferedReader(new FileReader(args[1]));
   
	 while(br1.ready()) {
		String w1 = br1.readLine();
		  String[] f1 = w1.split(" ");
			for(int i = 1; i < f1.length; i++) {
				wf1.add(f1[i]);
			}
		} br1.close();
		
	 while(br2.ready()) {
		String w2 = br2.readLine();
		  wf2.add(w2);
		}br2.close();
		
	} catch (FileNotFoundException e) {
		System.out.println(e);
	} catch (IOException e) {
		System.out.println(e);
	}
	 
//error_line: contains the lines where errors occur
ArrayList<Integer> error_line=new ArrayList<Integer>();

//Checkig that all words are part of the dictionary
int cont = 0;
int max;
  for(int m = 0; m < wf1.size(); m++) {
	max = cont;
	  for(int n = 0; n < wf2.size(); n++) {
		if(wf1.get(m).equals(wf2.get(n).toUpperCase())) {
			cont++;
		}
}
	  
if(cont == max) {
	error_line.add(m+1);
	}
}
		
// check that we don't have two identical words in the same file
for(int m = 0; m < wf1.size(); m++) {
  for(int n = 0; n < wf1.size(); n++) {
	if(m != n) {
	  if(wf1.get(m).equals(wf1.get(n))) {
		 error_line.add(m+1);
			}
		}
	}
}
	
//Making control between words below
for(int k = 1 ; k < wf1.size() ; k++) {
  String word1 = wf1.get(k-1);
	String word2 = wf1.get(k);
	  int dimention1 = word1.length();
		int dimention2 = word2.length();
		  int control = 0;
			
// first case: where one letter is removed from the next word
if(dimention1 > dimention2) {
	
//And here we have to check if more than one letter is removed thats means it's an error
if((dimention1 - dimention2)>1) {
	  error_line.add(k+1);
}
  
//Now i'm going to check that all the other letters between the two words are the same
control=chkRemove(word1,word2,dimention2);
}

//second case: where a letter is added to the next word
if(dimention2 > dimention1) {
		
// here we check if more than one letter is added thats means it's an error
if((dimention2 - dimention1) > 1) {
	error_line.add(k+1);
}
		
//checking that all the other letters between the two words are the same
control=chkInsertion(word1,word2,dimention1);
}
	
// now it's the moment to check the letters, and as it's known only one letter can change between two neighboring words
if(dimention1 == dimention2) {
	control=checkLetters(word1,word2,dimention1);
}
	
// and if the number of letters are different between two neighboring words is greater than one then thats means it's an error that occurs
if(control > 1) {
	error_line.add(k+1);
	}
}

//checking to remove the duplicate elements
for(int m = 0; m < error_line.size(); m++) {
  for(int n = 0; n < error_line.size(); n++) {
	if(m != n) {
	  if(error_line.get(m).equals(error_line.get(n))) {
		error_line.remove(n);
		}
	  }
   }
}

// if everything went well then it will print 'correct '
if(error_line.size() == 0) {
   System.out.println("CORRETTO");
}
  
else {		 
// otherwise it will print the lines where errors have occurred in ascending order
  Collections.sort(error_line);
	for(int m = 0; m < error_line.size(); m++) {
		System.out.println("ERRORE: linea "+error_line.get(m));
	}
  }				
}
	
public static int chkRemove(String word1, String word2,int dimention2) {
int control2=0;
 int index=0;
  int m = 0;
     
// until i find two different letters among the words I'm comparing, which is the letter removed, I go on
while(control2 == 0) {
  if(word1.charAt(m) != word2.charAt(m)) {
	control2++;
	  index = m;
	 }
   m++;
}

for(int n = index; n < dimention2; n++) {
  if(word1.charAt(n+1) != word2.charAt(n)) {
	control2++;
  }
}

//return the number of letters that i found differences between the two words
	return control2;
}

public static int chkInsertion(String word1,String word2, int dimention1) {
 int contr = 0;
   int m = 0;
	 int index = 0;
	  
// until i find two different letters among the words that i'm comparing, I go on
while(contr == 0) {
  if(word1.charAt(m) != word2.charAt(m)) {
	contr++;
	  index = m;
	 }
   m++;
}

for(int n = index; n < dimention1; n++) {
  if(word1.charAt(n) != word2.charAt(n+1)) {
	contr++;
  }
}

//return the number of letters that i have found differences between the two words
	return contr;
}
	
public static int checkLetters(String word1, String word2, int dimention1) {
 int chk = 0;
  for(int m = 0; m < dimention1; m++) {
	if(word1.charAt(m) != word2.charAt(m)) {
	  chk++;
	}
}
  
//return the number of letters that i have found differences between the two words
		return chk;
	}
}
