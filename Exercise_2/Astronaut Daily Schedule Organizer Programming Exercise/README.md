# Astronaut Daily Schedule Organizer

## Description
This Java program helps astronauts organize their daily tasks efficiently.  
It demonstrates practical usage of multiple design patterns:

- **Factory Pattern** – For creating tasks dynamically using `TaskFactory`.
- **Observer Pattern** – To notify observers (`ConflictNotifier`, `LogNotifier`) when tasks are added, removed, or conflict.
- **Singleton Pattern** – `ScheduleManager` ensures only one instance manages the daily schedule.

---

## Features
1. **Add a Task**  
   Add a task with description, start time, end time, and priority.  
   - Example:  add "Morning Exercise" 07:00 08:00 High

2. **Remove a Task**  
Remove a task by its description.  
- Example:  remove Morning Exercise


3. **View Tasks**  
Display all tasks sorted by start time.

4. **Conflict Detection**  
Automatically detects overlapping tasks and notifies observers.

5. **Observers**  
- `ConflictNotifier` prints conflict messages.  
- `LogNotifier` prints general log messages.

---

## Classes Overview

- **Task**: Represents a scheduled task with description, start/end time, priority, and completion status.  
- **TaskFactory**: Factory class for creating `Task` objects.  
- **Observer Interface**: Declares the `update(String message)` method.  
- **ConflictNotifier / LogNotifier**: Concrete observers for notifications.  
- **ScheduleManager**: Singleton class that manages tasks and notifies observers.  
- **AstronautScheduler**: Main class containing the command-line interface.



