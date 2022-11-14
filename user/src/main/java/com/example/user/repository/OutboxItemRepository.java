package com.example.user.repository;

import com.example.user.model.OutboxItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutboxItemRepository extends JpaRepository<OutboxItem, UUID> {
}
