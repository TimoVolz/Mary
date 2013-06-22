package tw.timovolz.mary;

public class calcQuestion {
	public String asText;
	public long asResult;
	public String asResultText;
	public calcQuestion( long category) {
	 long operand1 = tvUtils.randomNumber(2, 20);
	 long operand2 = tvUtils.randomNumber(11, 20);
	 this.asResult = operand1 * operand2;
	 this.asText = String.valueOf(operand1)+ " X " + String.valueOf(operand2) + " =";
	 this.asResultText = String.valueOf(this.asResult);
	}
	public boolean isCorrectAnswer( String aAnswer){
		if (aAnswer.equals(this.asResultText)) { return true; } else {return false;}
	}
	public boolean isCorrectStartOfAnswer( String aAnswer ){
		if ( this.asResultText.indexOf( aAnswer ) == 0 ) {return true;} else {return false;}
	}
}

