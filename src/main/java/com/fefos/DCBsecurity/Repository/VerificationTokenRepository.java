package com.fefos.DCBsecurity.Repository;

import com.fefos.DCBsecurity.Entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends
        JpaRepository<VerificationToken, Long> {
}
