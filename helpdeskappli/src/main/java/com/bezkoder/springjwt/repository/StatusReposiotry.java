package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.StatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusReposiotry extends JpaRepository<StatusModel,Long> {

}
