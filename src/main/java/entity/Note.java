package entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

public class Note {

    @Id
    private Long id;

    @NotNull
    private String title;

    private String shortDesc;

    @NotNull
    private String content;

    private List<Tag> tags;

    @NotNull
    @ManyToOne
    private User creator;

    public Note(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (!id.equals(note.id)) return false;
        if (!title.equals(note.title)) return false;
        if (shortDesc != null ? !shortDesc.equals(note.shortDesc) : note.shortDesc != null) return false;
        if (!content.equals(note.content)) return false;
        return creator.equals(note.creator);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (shortDesc != null ? shortDesc.hashCode() : 0);
        result = 31 * result + content.hashCode();
        result = 31 * result + creator.hashCode();
        return result;
    }
}
