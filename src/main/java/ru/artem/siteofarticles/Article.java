package ru.artem.siteofarticles;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private Integer article_id;

    @Size(min = 2, max = 255, message = "Article should be between 2 and 254 characters")
    @Column(name = "articleBody")
    @NotEmpty(message = "Article should not be empty")
    private String articleBody;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 20, message = "Title should be between 2 and 100 characters")
    @Column(name = "title")
    private String title;

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(String article) {
        this.articleBody = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
