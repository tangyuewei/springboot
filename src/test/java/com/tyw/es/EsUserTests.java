package com.tyw.es;

import com.tyw.document.UserDocument;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author tboss
 * <p>
 * Description:
 * </p>
 * @date 2020/4/1
 * @see com.tyw.es
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsUserTests {

	@Resource
	private ElasticsearchTemplate elasticsearchTemplate;

	@Resource
	private UserDocumentRespository userDocumentRespository;

	@Test
	public void testCreateIndex() {
		elasticsearchTemplate.createIndex(UserDocument.class);
		UserDocument user = new UserDocument();
		user.setId("123456");
		user.setUserName("Test");
		UserDocument saveUser = userDocumentRespository.save(user);
		Assert.assertNotNull(saveUser);
		System.out.println(userDocumentRespository.findById(user.getId()));
		elasticsearchTemplate.deleteIndex(UserDocument.class);
	}

}
