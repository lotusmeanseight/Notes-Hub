package entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.Id;
import java.util.List;

public class Hub {

    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<Category> category;
    private int memberLimit;
    private List<User> members;


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

    public int getMemberLimit() {
        return memberLimit;
    }

    public void setMemberLimit(int memberLimit) {
        this.memberLimit = memberLimit;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hub hub = (Hub) o;

        if (id != null ? !id.equals(hub.id) : hub.id != null) return false;
        if (name != null ? !name.equals(hub.name) : hub.name != null) return false;
        return category != null ? category.equals(hub.category) : hub.category == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
