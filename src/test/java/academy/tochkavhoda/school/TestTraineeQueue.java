package academy.tochkavhoda.school;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestTraineeQueue {

    @Test
    public void testAddAndRemoveTrainee() throws TrainingException {
        TraineeQueue queue = new TraineeQueue();
        Trainee trainee = new Trainee("Иван", "Иванов", 5);
        queue.addTrainee(trainee);
        assertFalse(queue.isEmpty());
        Trainee removed = queue.removeTrainee();
        assertEquals(trainee, removed);
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testRemoveFromEmptyQueue() {
        TraineeQueue queue = new TraineeQueue();
        assertThrows(TrainingException.class, queue::removeTrainee);
    }

    @Test
    public void testIsEmpty() {
        TraineeQueue queue = new TraineeQueue();
        assertTrue(queue.isEmpty());
        queue.addTrainee(new Trainee("Петр", "Петров", 4));
        assertFalse(queue.isEmpty());
    }
}