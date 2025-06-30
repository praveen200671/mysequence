package com.meditation.my_sequence.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.meditation.my_sequence.dto.AuthTokenEntity;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity,Integer> {
	Optional<AuthTokenEntity> findByToken(String token);
}
