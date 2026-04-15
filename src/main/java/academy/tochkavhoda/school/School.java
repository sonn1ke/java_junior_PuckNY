// academy.tochkavhoda.school.School
package academy.tochkavhoda.school;

import java.util.*;

public class School {
    private String name;
    private int year;
    private Set<Group> groups;

    private void validateName(String name) throws TrainingException {
        if (name == null || name.trim().isEmpty()) {
            throw new TrainingException(TrainingErrorCode.SCHOOL_WRONG_NAME);
        }
    }

    public School(String name, int year) throws TrainingException {
        validateName(name);
        this.name = name;
        this.year = year;
        this.groups = new HashSet<>();
    }

    public String getName() { return name; }

    public void setName(String name) throws TrainingException {
        validateName(name);
        this.name = name;
    }

    public int getYear() { return year; }

    public void setYear(int year) { this.year = year; }

    public Set<Group> getGroups() {
        return new HashSet<>(groups);
    }

    public void addGroup(Group group) throws TrainingException {
        if (group == null) throw new TrainingException(TrainingErrorCode.NULL_PARAMETER);
        for (Group g : groups) {
            if (g.getName().equals(group.getName())) {
                throw new TrainingException(TrainingErrorCode.DUPLICATE_GROUP_NAME);
            }
        }
        groups.add(group);
    }

    public void removeGroup(Group group) throws TrainingException {
        if (!groups.remove(group)) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
    }

    public void removeGroup(String name) throws TrainingException {
        Group toRemove = null;
        for (Group g : groups) {
            if (g.getName().equals(name)) {
                toRemove = g;
                break;
            }
        }
        if (toRemove == null) {
            throw new TrainingException(TrainingErrorCode.GROUP_NOT_FOUND);
        }
        groups.remove(toRemove);
    }

    public boolean containsGroup(Group group) {
        return groups.contains(group);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return year == school.year &&
                Objects.equals(name, school.name) &&
                Objects.equals(groups, school.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, groups);
    }
}