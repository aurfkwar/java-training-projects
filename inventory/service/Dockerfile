FROM adoptopenjdk/openjdk11:jdk-11.0.5_10-debian

VOLUME /tmp

# Copy service relevant jar to container
ADD target/insurance-1.0.11-SNAPSHOT.jar app.jar

# Configure timezone of jar to be US Central
ENV TZ=America/Chicago
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

EXPOSE 80/TCP

# Set envrionment default java_opts for default memory size
#	Can be overridden on run using -e JAVA_OPTS=""
ENV JAVA_OPTS "-Xms10024m -Xmx10024m"

#   We use the "executable" format (form is array of executable then each individual param)
#   This makes it so any CMD or command options passed in are appended properly to the end
#   However environment variables will not work properly
ENTRYPOINT [ "java", \
    # Execute our jar which we've renamed as app.jar for portability
    "-jar", "app.jar" ]

# Verify url responds to POST with unauthorized response
HEALTHCHECK --interval=30s --timeout=3s --start-period=1m \
    CMD curl -f "http://localhost:6090/insurance-service/status" -d '{}' -s -w "%{http_code}\n" | grep '401' --quiet