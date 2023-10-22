package com.fiap.controllSales.repository;

import com.fiap.controllSales.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {
}
