Intro
=====

This project features the Kafka messaging environment as managed by the [Confluent Platform](https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html). Look at the link for further information.

Quick Environment Setup
=======================

1) Download or copy the contents of the [Confluent Platform all-in-one Docker Compose file](https://raw.githubusercontent.com/confluentinc/cp-all-in-one/6.1.0-post/cp-all-in-one/docker-compose.yml), for example:
   
   `curl --silent --output docker-compose.yml \
   https://raw.githubusercontent.com/confluentinc/cp-all-in-one/6.1.0-post/cp-all-in-one/docker-compose.yml`

2) Start Confluent Platform (use the -d option to run in detach mode):
   
   `docker-compose up zookeeper broker`
   
3) To verify that the services are up and running, run the following command:
   
    `docker-compose ps`

4) Start the server; inside integration-tests/server-app

    `mvn compile quarkus:dev`

5) Start the client; inside integration-tests/client-app

   `mvn compile quarkus:dev`