package repositories;

import entities.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private List<Article> articles;

    public ArticleRepository() {
        articles = new ArrayList<>();
    }

    // Ajouter un nouvel article
    public void ajouterArticle(Article article) {
        articles.add(article);
    }

    // Lister tous les articles
    public List<Article> listerArticles() {
        return new ArrayList<>(articles);
    }

    // Rechercher un article par son nom
    public Article rechercherArticleParNom(String nom) {
        for (Article article : articles) {
            if (article.getNom().equalsIgnoreCase(nom)) {
                return article;
            }
        }
        return null;
    }

    // Mettre à jour la quantité d'un article
    public void mettreAJourQuantite(String nom, int nouvelleQuantite) {
        Article article = rechercherArticleParNom(nom);
        if (article != null) {
            article.setQuantite(nouvelleQuantite);
        } else {
            throw new RuntimeException("Article non trouvé pour le nom : " + nom);
        }
    }

    // Filtrer les articles en fonction de leur disponibilité
    public List<Article> listerArticlesDisponibles() {
        List<Article> disponibles = new ArrayList<>();
        for (Article article : articles) {
            if (article.getQuantite() > 0) {
                disponibles.add(article);
            }
        }
        return disponibles;
    }
}
