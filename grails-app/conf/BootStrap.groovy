import fr.isima.estouroDePilha.Badge
import fr.isima.estouroDePilha.Question
import fr.isima.estouroDePilha.Tag
import fr.isima.estouroDePilha.User

class BootStrap {

	def user1
	def user2
	def user3
	def user4
	def user5
	def user6
	def user7
	
	def tag1
	def tag2
	def tag3
	def tag4
	def tag5
	def tag6
	def tag7
	
    def init = { servletContext -> // Check whether the test data already exists. 
		// Mock Users
		if(!User.count()) { // Check whether the test data already exists.
			user1 =new User(
				login:"admin@groovyrocks.com",
				password:"adminadmin",
				pseudo:"admin",
				realName:"Administrator",
				role:"admin",
				birthDate : Date.parse("yyyy-MM-dd", "2000-01-01")
				).save(failOnError: true)
			user2 = new User(
				login: "mylene@jaimelegrails.com",
				password: "mimimimi",
				pseudo: "Mylene",
				realName : "Mylene SIMON",
				birthDate : Date.parse("yyyy-MM-dd", "1989-01-10")
				).save(failOnError: true)
			user3 = new User(
				login: "guillaume@jaimelegrails.com",
				password: "gigigigi",
				pseudo: "Guie",
				realName : "Guillaume SOUSA AMARAL",
				birthDate : Date.parse("yyyy-MM-dd", "1990-02-16")
				).save(failOnError: true)
			user4 = new User(
				login: "eric@southpark.com",
				password: "southpark",
				pseudo: "TheCoon",
				realName : "Eric CARTMAN",
				birthDate : Date.parse("yyyy-MM-dd", "1988-07-01")
				).save(failOnError: true)
			user5 = new User(
				login: "butters@southpark.com",
				password: "southpark",
				pseudo: "Butters",
				realName : "Leopold STOTCH",
				birthDate : Date.parse("yyyy-MM-dd", "1988-03-10")
				).save(failOnError: true)
			user6 = new User(
				login: "kenny@southpark.com",
				password: "southpark",
				pseudo: "Kenny",
				realName : "Kenneth MCCORMICK",
				birthDate : Date.parse("yyyy-MM-dd", "1988-03-22")
				).save(failOnError: true)
			user7 = new User(
				login: "notch@mojang.com",
				password: "mojangteam",
				pseudo: "Notch",
				realName : "Markus Persson",
				birthDate : Date.parse("yyyy-MM-dd", "1979-06-01")
				).save(failOnError: true)
		}
		// Mock Tags
		if (!Tag.count()) { // Check whether the test data already exists.
			tag1 = new Tag(tagname: "C#", 
				description: "C# is a multi-paradigm, managed, object-oriented programming language created by Microsoft in conjunction with the .netplatform. C# is also used with non-Microsoft implementations (most notably, Mono).\nVersions 1.0/1.2 and 2.0 of C# were submitted and approved as both ECMA and ISO/IEC standards. As of August 2012, there are no ECMA or ISO/IEC specifications for C# 3.0 and 4.0, however language specifications are available from Microsoft (3.0 and 4.0 respectively).\n"
							+ "The language's type system was originally static, with only explicit variable declarations allowed. However, the introduction of var (C# 3.0) and dynamic (C# 4.0) allow it to use type inference for implicit variable typing, and to consume dynamic type systems, respectively. Delegates (especially with lexical closure support for anonymous methods (C# 2.0) and lambda expressions (C# 3.0)) allow the language to be used for functional programming. C# 5.0 introduced the async and await keywords to simplify the use of asynchronous function calls.\n"
							+ "Compilation is usually done into the Common Intermediate Language (CIL), which is then JIT-compiled to native code (and cached) during execution in the Common Language Runtime (CLR). However, options like NGen (.NET) and AOT (Mono) mean that C# code can be directly compiled into the native image. Additionally, some frameworks (e.g. the Micro Framework) act as CIL interpreters, with no JIT.\n"
							+ "Generics in C# are provided in part by the runtime, unlike C++ templates (generics are resolved at compile time), or Java's generics (which use type-erasure).\n"
							+ "With the combination of Microsoft .NET for Windows (desktop/server), Mono (desktop/server/mobile), Silverlight / Moonlight (browser/mobile), Compact Framework (mobile), and Micro Framework (embedded devices), it is available for a wide range of platforms."
				).save(failOnError: true)
			tag2 = new Tag(tagname: "Java", 
				description: "Java is a high-level, platform-independent, object-oriented programming language and runtime environment. The Java language derives much of its syntax from c and c++, but its object model is simpler than c++ and has fewer low-level facilities. Java applications are typically compiled to bytecode (called class files) that can be executed by a Java Virtual Machine (jvm), independent of computer architecture. The jvm manages memory with the help of a garbage collector (see garbage-collection) in order to handle object removal from memory when not used anymore, as opposed to manually deallocating memory in other languages such as c++\n"
							+ "Java is a general-purpose, concurrent, class-based, object-oriented language designed to have as few implementation dependencies as possible. It is intended to let application developers \"write once, run anywhere\" (WORA): code that executes on one platform need not be recompiled to run on another. Java is a popular programming language, particularly for client-server web applications, with 10 million reported users. Java was originally developed by James Gosling at Sun Microsystems (which has since merged into Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them."
				).save(failOnError: true)
			tag3 =new Tag(tagname: "C++",
				description: "C++ is a statically-typed, free-form, (usually) compiled, multi-paradigm, intermediate-level general-purpose programming language; not to be confused with C. It was developed in the early 1980s by Bjarne Stroustrup as a set of extensions to the C programming language. Building on C, C++ improved type-safety and added support for automatic resource management, object-orientation, generic programming, exception handling, among other features."
				).save(failOnError: true)
			tag4 =new Tag(tagname: "SQL",
				description: "SQL is an acronym that stands for Structured Query Language (not Standardized).Database interaction requires the use of SQL, and over the years, vendors have implemented extensions of SQL (such as tsql for SQL Server & Sybase, plsql for Oracle, and plpgsql for PostgreSQL; there's no known tag for mysql's extensions) to provide more functionality as well as simplify it. Because of these extensions, SQL is fractured - syntax that works on one vendor does not necessarily work on another. ISO/IEC (formerly ANSI) standards have been beneficial in resolving such situations, but adoption is selective. ISO/IEC means that a query should be portable to other databases, but it doesn't mean that performance will be the same nor that performance will be on par with native functionality."
							+ "This tag should be used for general SQL programming language questions, in addition to tags for specific products (for example, questions about Microsoft SQL Server should use the sql-server tag) that implement some flavor of this language. SQL is the umbrella under which these products exist; tagging them by product (including version, e.g oracle11g, sql-server-2008) is the easiest way to know what functionality is available for the task at hand."
				).save(failOnError: true)
			tag5 =new Tag(tagname: "CSS",
				description: "CSS, short for Cascading Style Sheets, is a language used to control the visual presentation of documents written in a markup language, including html, xml, xhtml, svg and xul. In early days, the visual presentation was held by HTML attributes, then, CSS was introduced to separate the control of the visual presentation from the content."
				).save(failOnError: true)
			tag6 = new Tag(tagname: "JavaScript",
				description: "JavaScript is a dynamic, object-oriented, prototype-based, weakly typed language commonly used for scripting in web browsers. It is NOT the same as Java."
							+"It runs on nearly every OS, and a JavaScript engine is included in almost every mainstream web browser. Developed in 1995 by Brendan Eich at Netscape Communications, it was originally called LiveScript but was renamed to JavaScript due to Netscape's friendship with Sun Microsystems."
				).save(failOnError: true)
			tag7 = new Tag(tagname: "Groovy",
				description: "Groovy is an object-oriented programming language for the Java platform. Its features not available in Java include both static and dynamic typing, closures, operator overloading, native syntax for lists and maps, native support for regular expressions, polymorphic iteration, expressions embedded inside strings. It can be used as a scripting language for the Java Platform."
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
		// Mock Questions
		if(!Question.count() && User.count > 0 && Tag.count > 0) { // Check whether the test data already exists.
			def tags=[tag1,tag2,tag3]
			new Question(subject:"What are the differences between Generics in C# and Java and Templates in C++?",
				message:"I mostly use Java and generics are relatively new. I keep reading that Java made the wrong decision or that .NET has better implementations etc. etc."
						+"So, what are the main differences between C++, C#, Java in generics? Pros/cons of each?",
				author:user2,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-01 23:45")
				).save(failOnError: true)
				tags = [tag2]
			new Question(subject:"Differences between HashMap and Hashtable?",
				message:"What is the difference between a HashMap and a Hashtable in Java?"
						+"Which is more efficient for non-threaded applications?",
				author:user3,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-12 03:42")
				).save(failOnError: true)
				tags = [tag2,tag3]
			new Question(subject:"What is the equivalent of the C++ Pair<L,R> in Java?",
				message:"Is there a good reason why there is no Pair in Java? What would be the equivalent of this C++ construct? I would rather avoid reimplementing my own."
						+"It seems that 1.6 is providing something similar (AbstractMap.SimpleEntry), but this looks quite convoluted.",
				author:user6,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-14 21:42")
				).save(failOnError: true)
				tags = [tag2,tag7]
			new Question(subject:"How is the performance of Groovy compared with Java?",
				message:"Is there a good reason why there is no Pair in Java? What would be the equivalent of this C++ construct? I would rather avoid reimplementing my own."
						+"It seems that 1.6 is providing something similar (AbstractMap.SimpleEntry), but this looks quite convoluted.",
				author:user4,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-19 08:51")
				).save(failOnError: true)
				tags = [tag1]
			new Question(subject:"Cast int to enum in C#",
				message:"What's a quick and easy way to cast an int to an enum in C#?",
				author:user5,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-21 04:04")
				).save(failOnError: true)
				tags = [tag2]
			new Question(subject:"Uncatchable ChuckNorrisException",
				message:"Is it possible to construct a snippet of code in Java that would make a hypothetical java.lang.ChuckNorrisException uncatchable?"
						+"Thoughts that came to mind are using for example interceptors or aspect-oriented programming.",
				author:user7,
				tags:tags,
				postedDate: Date.parse("yyyy-MM-dd HH:mm", "2013-01-23 23:34")
				).save(failOnError: true)
		}
    }

	def destroy = { 
		
	}
}
