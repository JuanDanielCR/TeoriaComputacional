package sources;

public class ParseTree {
	
	private char symbol_derivated;
	private int position_derivated;
	private int valid_symbol;
	public StringBuilder leftmost_string =  new StringBuilder();

	public ParseTree(){
		valid_symbol = 1;
		symbol_derivated = 'B';
		leftmost_string.append("B");
	}
	
	public int derivate(char remaining){
		for(int i=0; i<leftmost_string.length(); i++)
			if(leftmost_string.charAt(i) == 'B' || leftmost_string.charAt(i) == 'R'){
				symbol_derivated = leftmost_string.charAt(i);
				position_derivated = i;
				break;
			}
		switch(remaining){
			case '(':
				if(symbol_derivated == 'B')
					leftmost_string.replace(position_derivated, position_derivated+1, "(RB");
				if(symbol_derivated == 'R')
					leftmost_string.replace(position_derivated, position_derivated+1, "(RR");
				break;
			case '#':
					leftmost_string.replace(position_derivated, position_derivated+1, "");
				break;
			case ')':
				if(symbol_derivated == 'R')
					leftmost_string.replace(position_derivated, position_derivated+1, ")");
				break;
			default:
				valid_symbol = -1;
				break;
		}
		return valid_symbol;
	}
}
