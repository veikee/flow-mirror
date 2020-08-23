package com.getui.flow.isgflowmirror.kafka;

import com.alibaba.fastjson.JSONObject;
import com.getui.flow.isgflowmirror.es.MirrorRequestBean;
import com.getui.flow.isgflowmirror.utils.DateTime;
import com.getui.flow.isgflowmirror.utils.IDUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @version 创建时间：2020/8/23 3:47 下午
 * @Author vic
 * @Description:
 */
@Component
@Slf4j
public class KafkaConsumer {

    private static final String TOPIC = "flow-mirror";
    private static final String TOPIC_GROUP = "gourp-mirror";

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @KafkaListener(topics = TOPIC, groupId = TOPIC_GROUP)
    public void flowMirror(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {

        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            String msg = message.get().toString();
            JSONObject data = JSONObject.parseObject(msg);
            String req_url = data.getString("Req_URL");
            String timestamp = data.getString("Req_Ts").substring(0,13);
            long timestampLong = Long.parseLong(timestamp);
            String method = data.getString("Req_Method");
            JSONObject body = data.getJSONObject("Req_Body");
            JSONObject header = data.getJSONObject("Req_Headers");
            String host = header.getString("Host");
            String user_agent = header.getString("User-Agent");
            String contentType = header.getString("Content-Type");

            MirrorRequestBean mirror = new MirrorRequestBean();
            mirror.setId(IDUtil.getId());
            mirror.setMethod(method);
            mirror.setContent_type(contentType);
            mirror.setUser_agent(user_agent);
            mirror.setHost(host);
            mirror.setUrl(req_url);
            mirror.setRequest_body(body.toJSONString());
            mirror.setCreate_time(DateTime.stampToDateSecondLong(timestampLong));
            mirror.setTimestamp(timestampLong);
            mirror.setCreate_time_min(DateTime.stampToDateMinLong(timestampLong));

            List<IndexQuery> list = new ArrayList<>();
            IndexQuery indexQuery = new IndexQuery();
            indexQuery.setObject(mirror);
            list.add(indexQuery);
            elasticsearchTemplate.bulkIndex(list);

            System.out.println("==========>>>>>Kafka consumer： Topic:" + topic + ",Message:" + msg);
            ack.acknowledge();
        }
    }

}
