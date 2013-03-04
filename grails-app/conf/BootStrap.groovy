import fr.isima.estouroDePilha.Badge
import fr.isima.estouroDePilha.Tag
import fr.isima.estouroDePilha.User

class BootStrap {

    def init = { servletContext -> // Check whether the test data already exists. 
		// Mock Users
		if(!User.count()) { // Check whether the test data already exists.
			new User(
				login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01")
				).save(failOnError: true)
			new User(
				login: "mylene@jaimelegrails.com",
				password: "mimimimi",
				pseudo: "Mylene",
				realName : "Mylene SIMON",
				birthDate : Date.parse("yyyy-MM-dd", "1989-01-10")
				).save(failOnError: true)
			new User(
				login: "guillaume@jaimelegrails.com",
				password: "gigigigi",
				pseudo: "Guie",
				realName : "Guillaume SOUSA AMARAL",
				birthDate : Date.parse("yyyy-MM-dd", "1990-02-16")
				).save(failOnError: true)
		}
		// Mock Tags
		if (!Tag.count()) { // Check whether the test data already exists.
			new Tag(tagname: "C#", 
				description: "C# is a multi-paradigm, managed, object-oriented programming language created by Microsoft in conjunction with the .netplatform. C# is also used with non-Microsoft implementations (most notably, Mono).\nVersions 1.0/1.2 and 2.0 of C# were submitted and approved as both ECMA and ISO/IEC standards. As of August 2012, there are no ECMA or ISO/IEC specifications for C# 3.0 and 4.0, however language specifications are available from Microsoft (3.0 and 4.0 respectively).\n"
							+ "The language's type system was originally static, with only explicit variable declarations allowed. However, the introduction of var (C# 3.0) and dynamic (C# 4.0) allow it to use type inference for implicit variable typing, and to consume dynamic type systems, respectively. Delegates (especially with lexical closure support for anonymous methods (C# 2.0) and lambda expressions (C# 3.0)) allow the language to be used for functional programming. C# 5.0 introduced the async and await keywords to simplify the use of asynchronous function calls.\n"
							+ "Compilation is usually done into the Common Intermediate Language (CIL), which is then JIT-compiled to native code (and cached) during execution in the Common Language Runtime (CLR). However, options like NGen (.NET) and AOT (Mono) mean that C# code can be directly compiled into the native image. Additionally, some frameworks (e.g. the Micro Framework) act as CIL interpreters, with no JIT.\n"
							+ "Generics in C# are provided in part by the runtime, unlike C++ templates (generics are resolved at compile time), or Java's generics (which use type-erasure).\n"
							+ "With the combination of Microsoft .NET for Windows (desktop/server), Mono (desktop/server/mobile), Silverlight / Moonlight (browser/mobile), Compact Framework (mobile), and Micro Framework (embedded devices), it is available for a wide range of platforms."
				).save(failOnError: true)
			new Tag(tagname: "Java", 
				description: "Java is a high-level, platform-independent, object-oriented programming language and runtime environment. The Java language derives much of its syntax from c and c++, but its object model is simpler than c++ and has fewer low-level facilities. Java applications are typically compiled to bytecode (called class files) that can be executed by a Java Virtual Machine (jvm), independent of computer architecture. The jvm manages memory with the help of a garbage collector (see garbage-collection) in order to handle object removal from memory when not used anymore, as opposed to manually deallocating memory in other languages such as c++\n"
							+ "Java is a general-purpose, concurrent, class-based, object-oriented language designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA): code that executes on one platform need not be recompiled to run on another. Java is a popular programming language, particularly for client-server web applications, with 10 million reported users. Java was originally developed by James Gosling at Sun Microsystems (which has since merged into Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them."
				).save(failOnError: true)
			new Tag(tagname: "C++",
				description: "C++ is a statically-typed, free-form, (usually) compiled, multi-paradigm, intermediate-level general-purpose programming language; not to be confused with C. It was developed in the early 1980s by Bjarne Stroustrup as a set of extensions to the C programming language. Building on C, C++ improved type-safety and added support for automatic resource management, object-orientation, generic programming, exception handling, among other features."
				).save(failOnError: true)
		}
		// Mock Badges
		if(!Badge.count()) { // Check whether the test data already exists.
			new Badge(badgeName: "Autobiographer",
				description: "Completed all user profile fields"
				).save(failOnError: true)
			new Badge(badgeName: "Supporter",
				description: "First up vote"
				).save(failOnError: true)
			new Badge(badgeName: "Critic",
				description: "First down vote"
				).save(failOnError: true)
			new Badge(badgeName: "Nice Answer",
				description: "Answer score of 10 or more"
				).save(failOnError: true)
		}
    }

	def destroy = { 
		
	}
}
