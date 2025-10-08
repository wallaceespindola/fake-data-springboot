APP_NAME=fake-data-springboot

.PHONY: run test docker compose clean install

run:
	mvn spring-boot:run

test:
	mvn -B test

docker:
	docker build -t $(APP_NAME):latest .

compose:
	docker compose up --build

clean:
	mvn -B clean

install:
	mvn clean install -DskipTests
