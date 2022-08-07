# Command pattern
An analogy of command pattern could be made with a waitress who takes the order
slip and gives it to the cook and notifies him/her of the order. The order slip
can be viewed as an object which has orderUp() method which has calls to the
methods of cook object based on the orders, for example, cook.makePizza(), etc.
The waitress doesn't need to know what is there in the order. Hence she could,
herself, be an object which has takeOrder() method which takes the orders from
different customers and calls orderUp() method of the order slip objects as she
knows that all the orders have orderUp() method.  This is all she needs to
know.

Codewise,

    order slip:
    ----------
    public void orderUp() {
        cook.makePizza();
        cook.makeBurger();
    }

Notice that the waitress and the cook are decoupled. The waitress just calls a
method on each order to get it prepared. The cook gets his instructions from
the order slip, he never needs to directly communicate with the waitess.

# Factory Method pattern
## Few guidelines
1. Try to avoid OO designs that violate the Dependency Inversion Principle.
2. No variable should hold reference to a concrete class. If you use 'new',
   you'll be holding reference to a concrete class. Use a factory to get around
   that.
3. No class should derive from a concrete class. If you do so, you'll depend on
   the concrete class. Derive from an abstraction like an interface or an abstract
   class.
4. No method should override an implemented method of any of its base classes.
   If you do so, your base class would be an abstraction to start with. Those
   methods implemented in the base class are meant to  be shared by all your
   subclasses.

## Dependency Inversion Principle:
  - Depend upon abstractions. Do not depend upon concrete classes.
  - It is similar to, "Program to an interface, not an implementation".
  - Both high-level and low-level components should depend on abstractions.

## Abstract Factory Pattern:
  - Provides an interface for creating families of related or dependent objects
    without specifying their concrete classes.

## Differences and similarities between Factory Method and Abstract Factory:
  - Both are good at decoupling applications from specific implementations.
  - Factory Method create objects through inheritance, Abstract Factory does it
    through object composition.
  - In Factory Method, you need to extend a class and provide an implementation
    for a factory method. The whole point is that you're using a subclass to do
    the creation for you. That way, the clients need to know the abstract type
    they are using, the subclass worries about the concrete type.
  - Abstract Factory provide an abstract type for creating a family of
    products. It groups together a set of related products.

## Object Oriented Principles:
  - Encapsulate what varies.
  - Favor composition over inheritance.
  - Program to interfaces, not implementations.
  - Strive for loosely coupled designs between objects that interact.
  - Classes should be open for extension but closed for modification.
  - Depend on abstractions. Do not depend on concrete classes.

# SOLID Design Principles
## Single Responsibility Principle
The class should do one task only.

## Open Closed Principle
Software entities should be open for extension but closed for modification.

## Liskov Substitution Principle
Subtypes should be substitutable for their base types. Inheritance should be
used when sub-class can replace the base class at all the places.

## Interface Segragation Principle
The dependency of one class to another one should depend on smallest possible
interface. Clients should not be forced to implement the interfaces they don't
use. Instead of one fat interface many small interfaces are preferred based on
groups of methods, each one serving one submodule.

## Dependency Inversion Principle
Depend upon abstractions (or interfaces) not upon concrete classes.


