package services;

import java.util.List;

import entities.Article;
import repositories.ArticleRepository;

public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // Créer un nouvel article
    public void creerArticle(String nom, int quantite, double prix) {
        Article article = new Article(nom, prix, quantite);
        articleRepository.ajouterArticle(article);
        System.out.println("Article créé avec succès.");
    }

    // Mettre à jour la quantité en stock d'un article
    public void mettreAJourStock(String nom, int nouvelleQuantite) {
        articleRepository.mettreAJourQuantite(nom, nouvelleQuantite);
        System.out.println("Quantité mise à jour avec succès.");
    }
    
    // Lister les articles disponibles
    public List<Article> listerArticlesDisponibles() {
        return articleRepository.listerArticlesDisponibles();
    }
}
