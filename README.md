# demo-scs-rabbit

## Run RabbitMQ
```bash
docker run --name rabbitmq -p 5672:5672 -p 15672:15672 -e RABBITMQ_DEFAULT_USER=aaa -e RABBITMQ_DEFAULT_PASS=123456 rabbitmq:3.8-management
```
## Metrics
Message sent count is available at the following endpoints
```bash
http://localhost:8080/actuator/prometheus
http://localhost:8080/actuator/metrics/messages.sent.direct
```