# kafkaNotify

## Kafka Producer Configuration
Uses KafkaTemplate class to send messages to the Kafka Cluster. It requires topic name and message to be sent. The message can be a custom template defined by the end application that can encapsulate all the details of the message including various attributes

## Kafka Producer REST Service
This API service allows Kafka Producers to access a REST API to send messages to a particluar topic

## Kafka Topic Configuration
Kafka Admin API allows creation / configuration of Topics in a Kafka Cluster programatically. Kafka Admin has been used configure topic related parameters for the kafka cluster

## Kafka Topic REST Service
REST service to create topics. we can expose more admin services related to topic configuration as well.
