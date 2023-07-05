package com.quest.examservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quest.examservices.model.Options;

@Repository("optionRepository")
public interface OptionRepository extends JpaRepository<Options, Long> {
    
}
