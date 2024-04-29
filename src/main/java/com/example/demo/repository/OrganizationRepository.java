package com.example.demo.repository;

import com.example.demo.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    List<Organization> findByNameContaining(String name);
}
