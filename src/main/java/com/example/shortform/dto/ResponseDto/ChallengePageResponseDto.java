package com.example.shortform.dto.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChallengePageResponseDto {
    private boolean next;
    private long totalCnt;
    private List<ChallengesResponseDto> challengeList;
}
