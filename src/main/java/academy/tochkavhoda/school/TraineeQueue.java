// academy.tochkavhoda.school.TraineeQueue
package academy.tochkavhoda.school;

import java.util.LinkedList;
import java.util.Queue;

public class TraineeQueue {
    private Queue<academy.tochkavhoda.school.Trainee> queue;

    public TraineeQueue() {
        queue = new LinkedList<>();
    }

    public void addTrainee(Trainee trainee) {
        queue.add(trainee);
    }

    public Trainee removeTrainee() throws TrainingException {
        Trainee t = queue.poll();
        if (t == null) {
            throw new TrainingException(TrainingErrorCode.EMPTY_TRAINEE_QUEUE);
        }
        return t;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}