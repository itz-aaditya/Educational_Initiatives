import java.util.*;

// ================== Task ==================
class Task {
    private String description;
    private String startTime; // format HH:mm
    private String endTime;
    private String priority;
    private boolean completed;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.completed = false;
    }

    public String getDescription() { return description; }
    public String getStartTime() { return startTime; }
    public String getEndTime() { return endTime; }
    public String getPriority() { return priority; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() { this.completed = true; }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description +
                " [" + priority + "]" + (completed ? " (Completed)" : "");
    }
}

// ================== Factory Pattern ==================
class TaskFactory {
    public static Task createTask(String description, String start, String end, String priority) {
        return new Task(description, start, end, priority);
    }
}

// ================== Observer Interface ==================
interface Observer {
    void update(String message);
}

// ================== Concrete Observers ==================
class ConflictNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Conflict Notification: " + message);
    }
}

class LogNotifier implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Log: " + message);
    }
}

// ================== Singleton Pattern ==================
class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    // Singleton instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void addTask(Task task) {
        if (!isValidTime(task.getStartTime()) || !isValidTime(task.getEndTime())) {
            notifyObservers("Invalid time format for task: " + task.getDescription());
            return;
        }

        for (Task t : tasks) {
            if (overlaps(task, t)) {
                notifyObservers("Task \"" + task.getDescription() +
                        "\" conflicts with \"" + t.getDescription() + "\"");
                return;
            }
        }

        tasks.add(task);
        notifyObservers("Task \"" + task.getDescription() + "\" added successfully.");
    }

    public void removeTask(String description) {
        Task found = null;
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                found = t;
                break;
            }
        }

        if (found != null) {
            tasks.remove(found);
            notifyObservers("Task \"" + description + "\" removed successfully.");
        } else {
            notifyObservers("Task not found: " + description);
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }

        tasks.sort(Comparator.comparing(Task::getStartTime));
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    private boolean overlaps(Task a, Task b) {
        return (a.getStartTime().compareTo(b.getEndTime()) < 0 &&
                a.getEndTime().compareTo(b.getStartTime()) > 0);
    }

    private boolean isValidTime(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }
}

// ================== Main Program ==================
public class AstronautScheduler {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        manager.addObserver(new ConflictNotifier());
        manager.addObserver(new LogNotifier());

        Scanner sc = new Scanner(System.in);
        System.out.println("Astronaut Daily Schedule Organizer");
        System.out.println("Commands: add, remove, view, exit");

        while (true) {
            System.out.print("> ");
            String command = sc.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) break;

            if (command.startsWith("add")) {
                // Example: add "Morning Exercise" 07:00 08:00 High
                try {
                    String[] parts = command.split("\"");
                    String description = parts[1];
                    String[] rest = parts[2].trim().split(" ");
                    String start = rest[0];
                    String end = rest[1];
                    String priority = rest[2];

                    Task task = TaskFactory.createTask(description, start, end, priority);
                    manager.addTask(task);
                } catch (Exception e) {
                    System.out.println("Invalid input format. Try: add \"TaskName\" 07:00 08:00 High");
                }
            } else if (command.startsWith("remove")) {
                String description = command.replace("remove", "").trim();
                manager.removeTask(description);
            } else if (command.equalsIgnoreCase("view")) {
                manager.viewTasks();
            } else {
                System.out.println("Unknown command. Use add, remove, view, exit");
            }
        }

        sc.close();
        System.out.println("Exiting Astronaut Scheduler. Goodbye!");
    }
}
