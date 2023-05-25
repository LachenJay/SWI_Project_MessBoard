package cz.osu.java.messboardapp.Form;


import cz.osu.java.messboardapp.model.BoardComment;
import cz.osu.java.messboardapp.model.BoardUser;
import cz.osu.java.messboardapp.model.BoardPost;
import cz.osu.java.messboardapp.repository.CommentRepository;
import lombok.*;
import org.apache.catalina.User;

import java.util.Date;

@Getter
@Setter
public class CommentForm
{
    private String text;

    private CommentRepository comRep;



    @Setter(AccessLevel.NONE)
    private Date createdAt;

    @Setter(AccessLevel.NONE)
    private Integer userId;

    @Setter(AccessLevel.NONE)
    private Integer postId;

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = new Date(createdAt.getTime());
    }
    public void setUser(BoardUser user) {
        this.userId = user.getUserId();
    }
    public void setPost(BoardPost post) {
        this.postId = post.getPostId();
    }

    public CommentForm(String text, BoardPost post)
    {
        BoardComment bC = new BoardComment();
        bC.setComment_id((int)comRep.count()+1);
        bC.setText(text);
        bC.setUser(post.getUserId());
        bC.setPostId(post);
        bC.setCreatedAt(new Date());
        comRep.save(bC);
    }

}
