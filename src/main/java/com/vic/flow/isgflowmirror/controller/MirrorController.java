package com.vic.flow.isgflowmirror.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 创建时间：2020/8/13 10:28 下午
 * @Author vic
 * @Description:镜像入口
 */
@RestController
public class MirrorController {

//    @Autowired
//    ElasticsearchTemplate elasticsearchTemplate;
//
//    @RequestMapping("/**")
//    public void mirror(HttpServletRequest request) throws Exception{
//        String method = request.getMethod();
//        String contentType = request.getContentType();
//        String user_agent = request.getHeader("user-agent");
//        String host = request.getRemoteHost();
//        String url = request.getRequestURI();
//
//        BufferedReader br = request.getReader();
//        String str, requestBody = "";
//        while((str = br.readLine()) != null){
//            requestBody += str;
//        }
//
//        Map paramMap = request.getParameterMap();
//        JSONObject params = (JSONObject)JSONObject.toJSON(paramMap);
//
//        MirrorRequestBean mirror = new MirrorRequestBean();
//        mirror.setId(IDUtil.getId());
//        mirror.setMethod(method);
//        mirror.setContent_type(contentType);
//        mirror.setUser_agent(user_agent);
//        mirror.setHost(host);
//        mirror.setUrl(url);
//        mirror.setParams(params.toJSONString());
//        mirror.setRequest_body(requestBody);
//        Date date = new Date();
//        mirror.setCreate_time(DateTime.getSecond(date));
//        mirror.setTimestamp(date.getTime());
//
//        List<IndexQuery> list = new ArrayList<>();
//        IndexQuery indexQuery = new IndexQuery();
//        indexQuery.setObject(mirror);
//        list.add(indexQuery);
//        elasticsearchTemplate.bulkIndex(list);
//    }
//
//    @RequestMapping("/createIndex")
//    public boolean createIndex(){
//        return elasticsearchTemplate.createIndex(MirrorRequestBean.class);
//    }


//    @RequestMapping("query")
//    public List<MirrorRequestBean> query(@PageableDefault Pageable pageable){
//        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(QueryBuilders.termQuery("url","/user/get")).withPageable(pageable).build();
//        List<MirrorRequestBean> results = elasticsearchTemplate.queryForList(searchQuery, MirrorRequestBean.class);
//        return results;
//    }

    @PostMapping("test")
    public String test(String param1,String param2){
        System.out.println(param1);
        return "success";
    }

}
