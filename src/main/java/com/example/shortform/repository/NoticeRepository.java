package com.example.shortform.repository;

import com.example.shortform.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllByUserIdAndCreatedAtAfterOrderByCreatedAtDesc(Long id, LocalDateTime now);

    boolean existsByUserIdAndNoticeLevel(Long id, Long id1);

    boolean existsByUserIdAndIsSuccessAndChallengeId(Long id, boolean b, Long challengeId);

    boolean existsByUserIdAndNoticeTypeAndCreatedAtBetween(Long id, Notice.NoticeType recommend, LocalDateTime today, LocalDateTime plusDays);

    boolean existsByPostIdAndUserId(Long postId, Long id);

    Notice findByPostIdAndUserId(Long postId, Long id);

    boolean existsByChallengeIdAndUserId(Long challengeId, Long id);

    List<Notice> findAllByChallengeIdAndUserId(Long challengeId, Long id);

    boolean existsByChallengeIdAndIsSuccess(Long id, boolean b);
}
