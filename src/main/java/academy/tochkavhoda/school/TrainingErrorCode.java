// academy.tochkavhoda.school.TrainingErrorCode
package academy.tochkavhoda.school;

public enum TrainingErrorCode {
    // Общие
    NULL_PARAMETER("Parameter cannot be null"),
    EMPTY_STRING("String cannot be empty"),

    // Group
    GROUP_WRONG_NAME("Group name is invalid"),
    GROUP_WRONG_ROOM("Group room is invalid"),
    TRAINEE_NOT_FOUND("Trainee not found in group"),

    // School
    SCHOOL_WRONG_NAME("School name is invalid"),
    DUPLICATE_GROUP_NAME("Group with this name already exists"),
    GROUP_NOT_FOUND("Group not found in school"),

    // TraineeMap
    DUPLICATE_TRAINEE("Trainee already exists in map"),

    // TraineeQueue
    EMPTY_TRAINEE_QUEUE("Queue is empty"),

    // TraineeBidiMap
    DUPLICATE_PASSPORT("Passport number already exists"),
    PASSPORT_NOT_FOUND("Passport not found"),

    // FigureBag
    FIGURE_NOT_FOUND("Figure not found in bag"),

    // Matrix
    MATRIX_EMPTY("Matrix is empty");

    private final String errorString;

    TrainingErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}