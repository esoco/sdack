# The SDACK project

The **Simple Development Application Component Kit** (aka SDACK) project is a collection of framework (or better: a **stack** of frameworks) that provide a foundation to easily build web applications. These applications are typically created by defining processes that encapsulate the business logic of the application, and entities that describe the persistent state. All parts of the stack make use of the **ObjectRelations** framework, a new programming paradigm that allows the generic modeling of relations between object similar as object orientation defines the modeling of objects with classes.

# License

This project is licensed under the [Apache 2.0 license]( http://www.apache.org/licenses/LICENSE-2.0) (see link or LICENSE file for details).  

The following illustration displays the current framework stack:

![SDACK](esoco Framework Stack.svg)
![SDACK](esoco Framework Stack.png)

One advantage of SDACK is that the depencies on additional external libraries is minimal. In fact there is only one mandatory library which is the open source GWT project. And even the access to that library is abstracted through the GEWT and Web Application Framework projects, thus making projects based on the frameworks widely independent from external APIs. All other external dependencies are related to the respective application environment, e.g. JDBC database drivers. The frameworks provide all functionality that is required for a typical application: persistence, visualization, logging, user interface, and more. And still the full framework stack is very compact regarding the number of API methods to learn as well as code size.

The main goal of the frameworks is to make application development as easy as possible while still providing the full functionality of all underlying APIs. This is achieved by several new technologies, first and foremost the ObjectRelations framework that introduces a new programming paradigm that is used throughout all levels of the stack. A major design principle of all frameworks is to hide as much non-essential code from the developer as possible by providing simple to use APIs that require no configuration for default behavior. They also use modern software design patterns like Generics, Functional Programming and Fluent Interfaces.

The following sections provide short descriptions of the layers in the framework stack, starting at the bottom with the most generic and least application-specific elements. They also contain links to detailed documenation for the respective layer.

## esoco-common

The esoco-common library contains a small set of essential functionality, mostly core interfaces and fundamental data structures. This library is completely independent from the ObjectRelations framework (which depends on it) and uses only a small set of standard Java APIs. It can be used in constrained Java environments like GWT where only a subset of Java APIs is available.

## ObjectRelations

ObjectRelations is a new development concept that is can be seen as an extension and enhancement of object-oriented software development. The main idea behind it is to model the relations between objects similar to the way object-orientation models the elements of a software development project. All frameworks on the stack above this project make extensive use of relations to achieve their purpose and are typically much more efficient than code that doesn't use this pattern. The ObjectRelations project also contains the code for functional programming that is used throughout all dependent frameworks. It is recommended to study the ObjectRelations documentation before other frameworks to get an understanding of the underlying principles.
esoco-lib

This library contains generic, application-independent code that are of use for almost all development projects. It defines fundamental data structures and interfaces and provides utility functions for several areas like I/O, reflection, string handling and more.

## Storage Framework

The storage framework (esoco-storage) provides a simple but powerful Abstraction to implement object persistence. It's generic API not only supports JDBC-based relational persistence engines but can also be easily adapted to different persistence concepts like object oriented databases or key-value stores (aka NoSQL databases). It provides direct persistence for arbitrary Java objects (POJOs) without the need for configuration other than defining the actual database connection. It is built on the ObjectRelations framework and the functional programming framework therein. Predicates from the latter are used for the definition of query criteria in a fluent way.

## Business Framework

The business framework (esoco-business) is the foundation for business-related applications. Based on ObjectRelations and the storage framework it features classes to model and persist business data and to define processes that create and modify business data. Processes can also perform interactions through application-specific user interfaces to query and present data to an application user. Besides processes another central element of the business framework are entities which represent a generic base to define persistent business data objects. Entities make the modeling of persistent data easy and even provide a simple way to integrate existing databases into a new software project that uses the esoco frameworks.

## GEWT / EWT

Most business applications needs some kind of user interface to interact with application users to display and input data. The GEWT framework is a generic user interface abstraction that uses the open source Google Web Toolkit (GWT) as the actual user interface implementation. GEWT has the same API as EWT, a desktop user interface framework that allows a Java desktop GUI to use any of the competing technologies AWT, Swing, and SWT. And with GEWT the same user interface can be displayed as a web application and vice versa with only minor adaptations. Another important aspect of EWT is that it provides a very simple and unified API for user interface implementations, freeing the developer from the need to handle the similar but differently implemented concepts of the UI toolkits.

## GWT Web Application Framework

The Web Application Framework (esoco-gwt) is the bridge between the business framework and GEWT, combining the business back-end (processes and persistent entities) with a GWT user interface into a consistent and easy to use framework for building client-server web applications. It handles the communication between the server side and the client running in a web browser, automatically transforming business data into visual representations in the browser and transferring user input to the server for process execution and persistence. It also features high-level components that are the building blocks for the implementation of complete web applications.

The Webapp framework also contains the base classes and core elements necessary to create a configurable application that can be deployed into an application server which uses a connection to a standard relational database like PostgreSQL or MySQL. The GwtApplication already supports the automatic historization of changes in persistent data, database and file logging, and background processing. It is only necessary to implement the business-specific entities and processes to create a full business application.