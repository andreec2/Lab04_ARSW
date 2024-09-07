package edu.eci.arsw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GrammarChecker {

	
	private SpellChecker esc;
	private SpellChecker ssp;
	String x;
        
        
	public SpellChecker getSpellCheckerEnglish() {
		return esc;
	}

	public SpellChecker getSpellCheckerSpanish() {
		return ssp;
	}

	@Autowired
	@Qualifier("EnglishSpellChecker")
	public void setEnglishSpellChecker(SpellChecker esc) {
		this.esc = esc;

	}

	@Autowired
	@Qualifier("SpanishSpellChecker")
	public void setSpanishSpellChecker(SpellChecker ssp) {
		this.ssp = ssp;

	}


	public String check(String text, String language){

		
		StringBuffer sb=new StringBuffer();
		if ("en".equalsIgnoreCase(language)){

			sb.append("Spell checking output:"+esc.checkSpell(text));
			sb.append("Plagiarism checking output: Not available yet");

		}else if ("es".equalsIgnoreCase(language)){

			sb.append("Spell checking output:"+ssp.checkSpell(text));
			sb.append("Plagiarism checking output: Not available yet");
		}

		return sb.toString();
		
	}
	
	
}
