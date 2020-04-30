import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class sequenz {
	
	String[][] abhaengigkeiten;
	
	public Sequenz (String [][] abh) {
		abhaengigkeiten = abh;
	}
	
	public List<String> anfangenmit() {
		List<String> rg = new ArrayList<String>();
		
		for (int i = 0; i < this.abhaengigkeiten.length;i++){
			if(!rg.contains(abhaengigkeiten[i][0])) {
				rg.add(abhaengigkeiten[i][0]);
			}
		}
		
		for (int i = 0; i < this.abhaengigkeiten.length;i++) {
			if(rg.contains(abhaengigkeiten[i][1])) {
				rg.remove(abhaengigkeiten[i][1]);
			}
		}
		
		return rg;
	}
	
	public boolean korekkteSequenz (String[] sequence) {
		Set<String> menge = new HashSet<>(Arrays.asList(sequence));
		return menge.size() == sequence.length;
	}
	
	public boolean weitermit (String a, List<String> gelesen) {
		for (int i = 0; i < this.abhaengigkeiten.length;i++) {
			if(abhaengigkeiten[i][1].equals(a)) {
				if(!gelesen.contains(abhaengigkeiten[i][0])) {return false;}
			}
		}
		return true;
	}
	
	public boolean isWellSorted( String[] sequence ) {
		List<String> anfang = anfangenmit();
		List<String> gelesen = new ArrayList<String>();
		
		if(anfang.contains(sequence[0]) && korekkteSequenz(sequence) ) {
			gelesen.add(sequence[0]);
			for (int i = 1; i < sequence.length;i++) {
				if(!anfang.contains(sequence[i])) {
					if(!weitermit(sequence[i],gelesen)) {return false;}
					gelesen.add(sequence[i]);
				}
				else {
					gelesen.add(sequence[i]);
				}
			}
			return true;
		}
		
		
		return false;
		
	}


public static void main(String[] args){
	Sequenz test = new Sequenz(new String[][]{{ "A" , "C" }, { "C", "D" }, { "B", "C" }});
	System.out.println(test.isWellSorted(new String[]{ "D" , "C", "B", "A" }));
}

}

