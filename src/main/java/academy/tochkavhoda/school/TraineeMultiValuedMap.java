// academy.tochkavhoda.school.TraineeMultiValuedMap
package academy.tochkavhoda.school;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import java.util.Collection;
import academy.tochkavhoda.school.Trainee;
import academy.tochkavhoda.school.TrainingException;
import academy.tochkavhoda.school.TrainingErrorCode;

public class TraineeMultiValuedMap {
    private MultiValuedMap<Integer, academy.tochkavhoda.school.Trainee> multiMap;

    public TraineeMultiValuedMap() {
        multiMap = new HashSetValuedHashMap<>();
    }

    public boolean addTrainee(academy.tochkavhoda.school.Trainee trainee) {
        return multiMap.put(trainee.getRating(), trainee);
    }

    public boolean removeTrainee(academy.tochkavhoda.school.Trainee trainee) {
        return multiMap.removeMapping(trainee.getRating(), trainee);
    }

    public Collection<Trainee> getTraineesByRating(int rating) {
        return multiMap.get(rating);
    }

    public boolean hasAnyBodyRating(int rating) {
        return multiMap.containsKey(rating) && !multiMap.get(rating).isEmpty();
    }

    public int getTraineesCount() {
        return multiMap.size();
    }
}