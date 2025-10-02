**Design Pattern**: Observer Pattern

**Use Case**: A YouTube channel notifies its subscribers automatically whenever a new video is uploaded. Subscribers can dynamically subscribe or unsubscribe, and all notifications are handled without the channel needing to know subscriber details.

**Explanation of the Code**:

-> Observer Interface (ISubscriber): Defines the update() method that observers implement to receive notifications.

-> Observable Interface (IChannel): Declares methods for subscribing, unsubscribing, and notifying observers.

-> Concrete Subject (Channel): Maintains a list of subscribers and notifies them whenever a new video is uploaded via notifySubscribers().

-> Concrete Observers (Subscriber): Implement ISubscriber and respond to updates from the Channel. Each subscriber can customize their reaction to updates.

-> Main Class: Demonstrates subscribing, unsubscribing, and automatic notification of subscribers whenever the channel uploads a new video.


**Key Benefit**: The Observer Pattern allows a loose coupling between subjects and observers, making it easy to add or remove subscribers dynamically without changing the subject’s code.
