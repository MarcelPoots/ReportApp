How to run:

mvn spring-boot:run

[Visit http://localhost:8080/report](http://localhost:8080/report)

Optional: Check DB schema via console
[Go to http://localhost:8080/h2-console](http://localhost:8080/h2-console)

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (leave blank)

ERROR: Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Circular view path [report]: would dispatch back to the current handler URL [/report] again. Check your ViewResolver setup!
