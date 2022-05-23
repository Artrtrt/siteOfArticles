package ru.artem.siteofarticles;

import org.springframework.data.repository.CrudRepository;


public interface ArticleRepository extends CrudRepository<Article, Integer> {

}

