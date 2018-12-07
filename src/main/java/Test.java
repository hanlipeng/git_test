import com.dao.TestEntityMapper;
import com.entity.TestEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hanlipeng
 * @date 2018/10/17
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestEntityMapper mapper = sqlSession.getMapper(TestEntityMapper.class);
        TestEntity testEntity = mapper.selectByPrimaryKey(1);
        System.out.println(testEntity.getJson());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("adsf1", "adf");
        map.put("adsf2", "adf");
        map.put("adsf3", "adf");
        map.put("adsf4", "adf");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        TestEntity insert = new TestEntity();
        insert.setJson(json);
        insert.setId(3);
        mapper.insert(insert);
        sqlSession.commit();
    }
}
