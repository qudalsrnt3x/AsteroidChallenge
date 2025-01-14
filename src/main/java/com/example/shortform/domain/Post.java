package com.example.shortform.domain;

import com.example.shortform.dto.request.PostRequestDto;
import com.example.shortform.dto.resonse.CommentResponseDto;
import com.example.shortform.dto.resonse.PostDetailPageResponseDto;
import com.example.shortform.dto.resonse.PostIdResponseDto;
import com.example.shortform.dto.resonse.PostResponseDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "challenge_id", nullable = false)
    private Challenge challenge;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToOne(mappedBy = "post", orphanRemoval = true)
    private ImageFile imageFile;

    public void setImageFile(ImageFile imageFile) {
        this.imageFile = imageFile;
    }

    public PostIdResponseDto toResponse() {
        return PostIdResponseDto.builder()
                .postId(id)
                .build();
    }

    public void update(PostRequestDto requestDto) {
        this.content = requestDto.getContent();
    }

    public PostResponseDto toResponse(List<CommentResponseDto> commentList, long cnt) {
        return PostResponseDto.builder()
                .postImage(imageFile.getFilePath())
                .postId(id)
                .content(content)
                .profileImage(user.getProfileImage())
                .levelName(user.getLevel().getName())
                .nickname(user.getNickname())
                .comments(commentList)
                .commentCnt(cnt)
                .build();
    }

    public PostDetailPageResponseDto toPageResponse(List<CommentResponseDto> commentList, boolean next, long num) {
        return PostDetailPageResponseDto.builder()
                .postImage(imageFile.getFilePath())
                .postId(id)
                .content(content)
                .profileImage(user.getProfileImage())
                .levelName(user.getLevel().getName())
                .nickname(user.getNickname())
                .comments(commentList)
                .next(next)
                .commentCnt(num)
                .build();
    }
}
