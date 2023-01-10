package decouverte_java;

import java.util.ArrayList;
import java.util.List;

public class ListeCourse {
    List<Article> maListe = new ArrayList<>();
    
    public void addArticle(double prix, String designation, int quantite) {
        Article unarticle = new Article(prix, designation, quantite);
        maListe.add(unarticle);
    }
    
    public void removeArticle(String designation) {
        for (Article unarticle : maListe) {
            if(unarticle.designation == designation) {
                maListe.remove(unarticle);
            }
        }
        
    }
    
    public double prixTt() {
        double prix = 0;
        for(Article unarticle : maListe) {
            prix += unarticle.prix * unarticle.quantite;
        }
        return prix;
    }
    public String toString() {
        String r = "";
        for(Article unarticle : maListe) {
            r += unarticle;
        }
        return r;
    }

}