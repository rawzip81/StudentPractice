package com.rajeeb.studentpractice.repository;

import com.rajeeb.studentpractice.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long>{
    void deleteById(Long pId);
}
