package ru.artem.siteofarticles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public void save(Article article) {
        articleRepository.save(article);
    }

    public Iterable<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article findById(int id){
            return articleRepository.findById(id).get();//может быть ошибка
    }

    public void update(int id, Article article) {
        if (articleRepository.existsById(id)) {
            Article updateArticle = articleRepository.findById(id).get();
            updateArticle.setArticleBody(article.getArticleBody());
            updateArticle.setTitle(article.getTitle());
            articleRepository.save(updateArticle);
        }//или ошмбка
    }

    /*
    public void update(Article article) {
        int id = article.getArticle_id();
        if (articleRepository.existsById(id)) {
            Article updateArticle = articleRepository.findById(id).get();
            updateArticle.setArticleBody(article.getArticleBody());
            updateArticle.setTitle(article.getTitle());
            articleRepository.save(updateArticle);
        }//или ошмбка
    }*/

    public void delete(int id) {
        Optional<Article> a = articleRepository.findById(id);
        if (a.isPresent()) {
            Article deleteArticle = a.get();
            articleRepository.delete(deleteArticle);
        }//или ошибка
    }
}
