FROM java:8
MAINTAINER Emmanuel Evuazeze <github.com/evuazeze>

ENTRYPOINT ["java", "-jar", "restaurant-reviews-backend.jar"]

# Add Maven dependencies (not shaded into the artifact; Docker-cached)
# ADD target/lib           /usr/share/myservice/lib
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} ${JAR_FILE}
