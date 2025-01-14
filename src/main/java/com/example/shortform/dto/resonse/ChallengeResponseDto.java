package com.example.shortform.dto.resonse;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChallengeResponseDto{
    private Long challengeId;
    private Long userId;
    private String title;
    private String content;
    private int maxMember;
    private int currentMember;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isPrivate = false;
    private String categoryName;
    private List<TagNameResponseDto> tagNameList;
    private List<MemberResponseDto> members;
    private String status;
    private List<String> imageUrlList;
}
