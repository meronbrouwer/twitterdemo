# Build
mvn clean package && docker build -t nl.han.meron/javaeedemo .

# RUN

docker rm -f javaeedemo || true && docker run -d -p 8080:8080 -p 4848:4848 --name javaeedemo nl.han.meron/javaeedemo 