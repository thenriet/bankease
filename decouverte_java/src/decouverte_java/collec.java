package decouverte_java;
import java.util.ArrayList;
import java.util.List;

public class collec {
	
	List<Article> maListe = new ArrayList<>();
	
	public void addArticle(Article unarticle) {
		maListe.add(unarticle);
	}
	
	public void removeArticle(Article unarticle) {
		maListe.remove(unarticle);
	}
	
    public static double prixTt() {
        double prix = 0;
        try {
			for(Article unarticle : maListe) {
			    prix += unarticle.prix*unarticle.quantite;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return prix;
    }
	
	public String ToString() {
		String r="";
        for(Article unarticle : maListe) {
            r+=unarticle.quantite + " : " + unarticle.designation + "\n";
        }
        
        return r;
	}

}
