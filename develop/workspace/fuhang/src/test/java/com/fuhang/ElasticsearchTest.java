package com.fuhang;

import com.fuhang.util.ElasticSearchUtils;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElasticsearchTest extends ApplicationTests {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Test
    public void test1() {
        try
        {
            Map<String, Object> properties = new HashMap<String, Object>();
            Map<String, Object> propertie = new HashMap<String, Object>();
            propertie.put("type", "text"); // 类型
            // propertie.put("index",true);
//            propertie.put("analyzer", "ik_max_word"); // 分词器
            properties.put("title", propertie);

            XContentBuilder builder = XContentFactory.jsonBuilder();
            builder.startObject()
                    .startObject("mappings")
                    .startObject("_doc")
                    .field("properties", properties)
                    .endObject()
                    .endObject()
                    .startObject("settings")
                    .field("number_of_shards", 3)
                    .field("number_of_replicas", 1)
                    .endObject()
                    .endObject();

            CreateIndexRequest request = new CreateIndexRequest("demo1").source(builder);
            highLevelClient.indices().create(request, RequestOptions.DEFAULT);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        Map<String, Object> properties = new HashMap<String, Object>();

        builder.startObject("mappings")
                .startObject("testType")
                .field("properties" , properties)
                .endObject()
                .endObject()

        ;
    }

    @Test
    public void test3() {
        Map map = new HashMap();
        map.put("code", "1");
        List<String> result = ElasticSearchUtils.multiSearch(map, 10, "demo");
        System.out.println(result.size());
        System.out.println(result);
    }

}
