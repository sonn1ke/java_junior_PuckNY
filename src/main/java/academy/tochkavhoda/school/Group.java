// academy.tochkavhoda.school.Group
package academy.tochkavhoda.school;

import java.util.*;
import java.util.stream.Collectors;

public class Group {
    private String name;
    private String room;
    private List<academy.tochkavhoda.school.Trainee> trainees;

    // вспомогательный метод для проверки строк
    private void validateString(String value, TrainingErrorCode errorCode) throws TrainingException {
        if (value == null || value.trim().isEmpty()) {
            throw new TrainingException(errorCode);
        }
    }

    public Group(String name, String room) throws TrainingException {
        validateString(name, TrainingErrorCode.GROUP_WRONG_NAME);
        validateString(room, TrainingErrorCode.GROUP_WRONG_ROOM);
        this.name = name;
        this.room = room;
        this.trainees = new ArrayList<>();
    }

    public String getName() { return name; }

    public void setName(String name) throws TrainingException {
        validateString(name, TrainingErrorCode.GROUP_WRONG_NAME);
        this.name = name;
    }

    public String getRoom() { return room; }

    public void setRoom(String room) throws TrainingException {
        validateString(room, TrainingErrorCode.GROUP_WRONG_ROOM);
        this.room = room;
    }

    public List<academy.tochkavhoda.school.Trainee> getTrainees() {
        return new ArrayList<>(trainees); // защитная копия
    }

    public void addTrainee(academy.tochkavhoda.school.Trainee trainee) {
        trainees.add(trainee);
    }

    public void removeTrainee(academy.tochkavhoda.school.Trainee trainee) throws TrainingException {
        if (!trainees.remove(trainee)) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
    }

    public void removeTrainee(int index) throws TrainingException {
        if (index < 0 || index >= trainees.size()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        trainees.remove(index);
    }

    public academy.tochkavhoda.school.Trainee getTraineeByFirstName(String firstName) throws TrainingException {
        for (academy.tochkavhoda.school.Trainee t : trainees) {
            if (t.getFirstName().equals(firstName)) {
                return t;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public academy.tochkavhoda.school.Trainee getTraineeByFullName(String fullName) throws TrainingException {
        for (academy.tochkavhoda.school.Trainee t : trainees) {
            if (t.getFullName().equals(fullName)) {
                return t;
            }
        }
        throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
    }

    public void sortTraineeListByFirstNameAscendant() {
        trainees.sort(Comparator.comparing(academy.tochkavhoda.school.Trainee::getFirstName));
    }

    public void sortTraineeListByRatingDescendant() {
        trainees.sort((t1, t2) -> Integer.compare(t2.getRating(), t1.getRating()));
    }

    public void reverseTraineeList() {
        Collections.reverse(trainees);
    }

    public void rotateTraineeList(int positions) {
        if (trainees.isEmpty()) return;
        int shift = positions % trainees.size();
        if (shift == 0) return;
        Collections.rotate(trainees, -shift); // положительное - вправо, отрицательное - влево
    }

    public List<academy.tochkavhoda.school.Trainee> getTraineesWithMaxRating() throws TrainingException {
        if (trainees.isEmpty()) {
            throw new TrainingException(TrainingErrorCode.TRAINEE_NOT_FOUND);
        }
        int maxRating = trainees.stream().mapToInt(academy.tochkavhoda.school.Trainee::getRating).max().getAsInt();
        return trainees.stream()
                .filter(t -> t.getRating() == maxRating)
                .collect(Collectors.toList());
    }

    public boolean hasDuplicates() {
        Set<academy.tochkavhoda.school.Trainee> set = new HashSet<>();
        for (academy.tochkavhoda.school.Trainee t : trainees) {
            if (set.contains(t)) {
                return true;
            }
            set.add(t);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name) &&
                Objects.equals(room, group.room) &&
                Objects.equals(trainees, group.trainees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, room, trainees);
    }
}