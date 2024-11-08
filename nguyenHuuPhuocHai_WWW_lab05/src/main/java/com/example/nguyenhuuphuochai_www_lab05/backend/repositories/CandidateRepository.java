package com.example.nguyenhuuphuochai_www_lab05.backend.repositories;

import com.example.nguyenhuuphuochai_www_lab05.backend.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
