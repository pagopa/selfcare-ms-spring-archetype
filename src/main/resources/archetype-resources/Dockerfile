FROM adoptopenjdk/openjdk11:alpine-jre@sha256:7bad1492ecbbf775a7105f5cba2e4fa2fe81f95a21a3ac74c9e7af5513c48ba2
ADD https://github.com/microsoft/ApplicationInsights-Java/releases/download/3.1.1/applicationinsights-agent-3.1.1.jar /applicationinsights-agent.jar
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]

