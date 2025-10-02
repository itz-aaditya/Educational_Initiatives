Design Pattern: Decorator Pattern

Use Case: Dynamically add multiple abilities or power-ups to a game character (Mario) without modifying the original character class. Each power-up can be stacked or combined at runtime.

Explanation of the Code:

Component Interface (Character): Defines the common method getAbilities() for Mario and all decorators.

Concrete Component (Mario): The basic character with no power-ups.

Abstract Decorator (CharacterDecorator): Implements Character and contains a reference to another Character, enabling dynamic extension.

Concrete Decorators (HeightUp, GunPowerUp, StarPowerUp): Extend CharacterDecorator to add specific abilities to the character. Each decorator wraps a Character object and enhances its behavior.

Main Class: Demonstrates stacking multiple decorators on a single Mario object, showing how abilities can be dynamically composed at runtime.

Key Benefit: The Decorator Pattern allows behavior to be added to objects dynamically without modifying existing code, supporting flexible and reusable enhancements.