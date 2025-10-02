Design Pattern: Factory Pattern

Use Case: Creating different types of burgers from different burger chains without exposing the client code to the actual burger creation logic. The client just asks the factory for a specific type of burger, and the factory handles the creation.

Explanation of the Code:

-> Burger Interface: Defines a common method prepare() for all burgers.

-> Concrete Burger Classes: BasicBurger, StandardBurger, PremiumBurger, and their wheat variants implement the Burger interface with their own preparation steps.

-> BurgerFactory Interface: Declares a method createBurger(String type) for producing burgers.

-> Concrete Factories: SinghBurger and KingBurger implement BurgerFactory and encapsulate the creation logic for different types of burgers.

-> Main Class: The client code (factory_design) uses a factory (SinghBurger) to create a burger without knowing the exact class being instantiated. This allows easy extension and maintenance.

Key Benefit: The Factory Pattern separates object creation from usage, making it easy to add new burger types or chains without changing client code.