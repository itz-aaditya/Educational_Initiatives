**Design Pattern**: Prototype Pattern

**Use Case**: Efficiently create multiple NPCs (Non-Player Characters) in a game by cloning a template NPC instead of creating each one from scratch, which may involve heavy setup.

**Explanation of the Code**:

-> Prototype Interface (Prototype<T>): Declares the clone() method to produce a copy of the object.

-> Concrete Prototype (NPC): Implements the clone() method using a copy constructor. The class simulates a heavy setup when creating a new NPC from scratch, making cloning more efficient.

-> Main Class: Demonstrates creating a template NPC (alien) and cloning it to produce multiple NPCs (alienCopy1, alienCopy2). Shows that cloned objects can be modified independently without affecting the original.


**Key Benefit**: The Prototype Pattern allows efficient object creation by cloning existing objects, reducing initialization overhead and supporting dynamic object configuration.
