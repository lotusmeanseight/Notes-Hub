package lotus.entity;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Category {

    @Id
    private Long id;
    @NotNull
    private String name;
    private String desc;
    private Color color;
    private List<Tag> tags;

    public Category(String name){
        this.name = name;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        this.color = new Color(random.nextInt(0, 256), random.nextInt(0, 256),
                random.nextInt(0, 256));
    }

    public Category(String name, String color){
        this.name = name;
        this.color = Color.decode(color);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        return color != null ? color.equals(category.color) : category.color == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
