package com.example.shortform.dto.ResponseDto;

import com.example.shortform.domain.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class RankingResponseDto {

    private Long userId;
    private String nickname;
    private String profileImage;
    private int rankingPoint;
    private String level;
    private int rank;
    private String status;

    public RankingResponseDto(User user){
        this.userId = user.getId();
        this.nickname = user.getNickname();
        this.profileImage = user.getProfileImage();
        this.rankingPoint = user.getYesterdayRankingPoint();
        this.level = user.getLevel().getName();
        this.rank = user.getYesterdayRank();
        this.status = user.getRankStatus();

    }
}
