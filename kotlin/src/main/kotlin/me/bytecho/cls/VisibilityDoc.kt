package me.bytecho.cls

/**
 *
 * Created by Alan on 2017/1/16.
 */


//for pkg
/*
----If you do not specify any visibility modifier,
    public is used by default, which means that your declarations will be visibleeverywhere;
----If you mark a declaration
    private, it will only be visible inside the file containing the declaration;
----If you mark it
    internal, it is visible everywhere in the same module;
----protected is not available for top-level declarations*/

//for cls and prop
/*
----private means visible inside this class only (including all its members);
----protected — same as private+ visible in subclasses too;
----internal— any client inside this module who sees the declaring class sees its internal members;
----public— any client who sees the declaring class sees its public members.*/

/*NOTE for Java users: outer class does not see private members of its inner classes in Kotlin.
If you override a protected member and do not specify the visibility explicitly, the overriding member will also have
protected visibility.*/

//module
/*The internal visibility modifier means that the member is visible with the same module. More specifically, a module is a set of
Kotlin files compiled together:
----an IntelliJ IDEA module;
----a Maven or Gradle project;
----a set of files compiled with one invocation of the Ant task.*/