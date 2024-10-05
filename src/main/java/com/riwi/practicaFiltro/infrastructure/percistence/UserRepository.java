package com.riwi.practicaFiltro.infrastructure.percistence;

import com.riwi.practicaFiltro.domain.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
