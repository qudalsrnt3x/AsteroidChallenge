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
public class PostResponseDto {
    private Long postId;
    private String nickname;
    private String profileImage;
    private String postImage;
    private String content;
    private String createdAt;
    private Long commentCnt;
    private List<CommentResponseDto> comments;

    public PostResponseDto setCreatedAt(String createdAt) {
        return PostResponseDto.builder()
                .createdAt(createdAt)
                .build();
    }
}
