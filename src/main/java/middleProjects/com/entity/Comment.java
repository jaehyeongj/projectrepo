package middleProjects.com.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import middleProjects.com.dto.comment.CommentRequestDto;

import javax.persistence.*;

@Getter
@Entity
@RequiredArgsConstructor
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String contents;
    @Column(nullable = true)
    private Long recommendCount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Comment(String contents, Board board, Member member ){
        this.contents = contents;
        this.board = board;
        this.member = member;
        // board에 list보고 맞춰가야함. ex) board.getCommentList().add(this);
    }
    public void memberAndCommentWriterEqualCheck(String username){
        if(!this.member.getUsername().equals(username)){
            //TODO: 추후에 핸들링 할 수 있도록 exception 수정요망.
            throw new IllegalArgumentException("댓글작성자와 멤버 불일치");
        }
    }

    public void updateComment(String contents) {
        this.contents = contents;
    }
}
