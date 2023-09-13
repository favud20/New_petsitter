package com.pet.sitter.common.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Setter
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@EntityListeners(AuditingEntityListener.class)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noNo;

    @Column(length = 45)
    private String noTitle;

    @Column(columnDefinition = "text")
    private String noContent;

    @Column
    private LocalDateTime noDate = LocalDateTime.now();

    @Column
    @ColumnDefault("0")
    private Integer noViewCnt;

    //조회수증가
    public void increaseViewCount() {
        this.noViewCnt++;
    }

    // NoticeFile 리스트에 대한 getter와 setter 메서드
    // Notice 엔티티에서 NoticeFile 리스트를 관리
    @Getter
    @OneToMany(mappedBy = "notice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoticeFile> noticeFiles = new ArrayList<>();


    public void setNoticeFiles(List<NoticeFile> noticeFiles) {
        this.noticeFiles = noticeFiles;
    }

    // NoticeFile 객체를 Notice 엔티티에 추가하는 메서드
    public void addNoticeFile(NoticeFile noticeFile) {
        noticeFiles.add(noticeFile);
        noticeFile.setNotice(this); // 양방향 관계 설정
    }

    @Builder
    public Notice(Long noNo, String noTitle, String noContent, LocalDateTime noDate, Integer noViewCnt, List<NoticeFile> noticeFiles) {
        this.noNo = noNo;
        this.noTitle = noTitle;
        this.noContent = noContent;
        this.noDate = noDate;
        this.noViewCnt = noViewCnt;
        this.noticeFiles = noticeFiles;
    }
}
