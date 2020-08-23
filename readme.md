### ES版本：6.2.3

### Kafka版本：2.6.0

### Kafka topic：flow-mirror

### es索引信息见文件 ：[es数据格式.json]()

### goreplay写入kafka指令

sudo ./gor --input-raw :9400 --input-raw-track-response --output-kafka-host '127.0.0.1:9092' --output-kafka-topic 'flow-mirror' --output-kafka-json-format
