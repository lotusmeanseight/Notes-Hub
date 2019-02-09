package entity;

import org.neo4j.ogm.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Hub {

    @Id
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private List<Category> categories;
    private int memberLimit;
    @NotNull
    private User admin;
    private List<User> members;

    public Hub(User admin, String name, List<Category> categories){
        this.admin = admin;
        this.name = name;
        this.categories = categories;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hub hub = (Hub) o;

        if (id != null ? !id.equals(hub.id) : hub.id != null) return false;
        if (name != null ? !name.equals(hub.name) : hub.name != null) return false;
        return categories != null ? categories.equals(hub.categories) : hub.categories == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
