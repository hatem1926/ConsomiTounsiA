package tn.ConsomiTounsi.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.ConsomiTounsi.Entities.Category;



public interface categoryrepository  extends JpaRepository<Category, Integer> {

}
