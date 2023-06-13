package org.bjsxt.controller;

import jdk.internal.org.objectweb.asm.TypeReference;
import org.springframework.util.StringUtils;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @PostMapper("/save")
    public int save(int sid,String sanme){
        return 1;
    }

    //TODO 产生堆外内存溢出：outOfDirectMemoryError
    public List<CategoryEntity> getLevel1Categorys(){
        long l = System.currentTimeMillis();
        List<CategoryEntity> categoryEntities = baseMapper.selectList(new QueryWrapper<CategoryEntity>);
        System.out.println("消耗时间："+(System.currentTimeMillis()-1));
         return categoryEntities;
    }

    public Map<String, List<Catelog2Vo>> getCatalogJson(){
        //给缓存中放json字符串，拿出的json字符串，还用逆转为能用的对象类型，【序列化与反序列化】

        //1.加入缓存逻辑，缓存中存的数据是json字符串
        //JSON跨语言，跨平台兼容。
       String catalogJSON = redisTemplate.opsForValue.get("catalogJSON");
        if (StringUtils.isEmpty(catalogJSON)) {
             //2.缓存中没有，查询数据库
             Map<String,List<Catelog2Vo>> catalogJsonFromDb = getCatalogJsonFromDb();
             //3.查到的数据再放入缓存，将对象转为json放在缓存中
           String s = JSON.toJSONString(catalogJsonFromDb);
            redisTemplate.opsForValue().set("catalogJSON",s);
        }

        //转为我们指定的对象
        Map<String,List<Catelog2Vo>> result = JSON.parseObject(catalogJSON,new TypeReference());
          return result;
    }

    //从数据库查询并封装分类数据
    public Map<String,List<Catelog2Vo>> getCatalogJsonFromDb(){
        //1.如果缓存中有就用缓存的
        //Map<String,List<Catelog2Vo>> catalogJson = (Map<String,List<Catelog2Vo>>)
        //if(cache.get("catalogJson") == null){
        // 调用业务  XXXX
        //返回数据又被放入缓存
        // cache.put("catalogJson",parant_cid)；
        // }
        //return catalogJson;
        //只要是同一把锁，就能锁住，需要这个锁

        synchronized (this){
            //1.将数据库的多次查询变为一次
            List<CategoryEntity> selectList= baseMapper.selectList("null");

             List<CategoryEntity> level1Categorys = getParent_cid(selectList,);

        }

    }
    public List<SecKillSkuRedisTo> getCurrentSeckillSkus(){
        //1.确定当前时间属于哪个秒杀场次
        //1970
        long time = new Date().getTime();
       Set<String> keys = redisTemplate.keys(SESSIONS_CACHE_PREFIX+"*");
        for (String key : keys) {
            String replace = key.replace(SESSIONS_CACHE_PREFIX,"");
            String[] s = replace.split("-");
            long start = Long.parseLong(s[0]);
            long end = Long.parseLong(s[1]);
            if (time >= start && time <= end) {
                //2.获取这个秒杀场次需要的所有商品信息
                
            }


        }


    }


}
