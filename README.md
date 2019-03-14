# RestTemplate-Example


## Tracing
This project uses OpenTracing through Jaeger.
To test this locally you can spin up a local environment using the command below;
View Jaeger at <http://localhost:16686>
```bash
docker run -d --rm --name jaeger \
  -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  -p 9411:9411 \
  jaegertracing/all-in-one:1.8
```