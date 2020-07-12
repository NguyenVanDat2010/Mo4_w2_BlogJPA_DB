package blog.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // Đánh dấu đây là table trong db
@Table(name = "Blogs")
public class Blog {
    @Id //Đánh dấu là primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Giúp tự động tăng
    private Long id;
    private String author;
    @Type(type = "text")
    private String content;
    @Column(name = "create_at")
//    @CreationTimestamp
    @UpdateTimestamp
    private Timestamp createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
