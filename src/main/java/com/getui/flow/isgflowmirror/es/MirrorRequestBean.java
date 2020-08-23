package com.getui.flow.isgflowmirror.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @version 创建时间：2020/8/13 11:06 下午
 * @Author vic
 * @Description:
 */
@Data
@Document(indexName = "mirror", type = "mirrorRequest")
public class MirrorRequestBean implements Serializable {

    public MirrorRequestBean() {
    }

    public MirrorRequestBean(long id, String method, String content_type, String user_agent,
                             String host, String url, String request_body, String params,
                             long timestamp, long create_time, long create_time_min) {
        this.id = id;
        this.method = method;
        this.content_type = content_type;
        this.user_agent = user_agent;
        this.host = host;
        this.url = url;
        this.request_body = request_body;
        this.params = params;
        this.timestamp = timestamp;
        this.create_time = create_time;
        this.create_time_min = create_time_min;
    }

    @Id
    private long id;

    private String method;

    private String content_type;

    private String user_agent;

    private String host;

    @Field(analyzer = "url", type = FieldType.Text)
    private String url;

    private String request_body;

    private String params;

    private long timestamp;

    private long create_time;

    private long create_time_min;
}
