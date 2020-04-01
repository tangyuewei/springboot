package com.tyw.document;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

/**
 * @author tboss
 * <p>
 * Description: es文档
 * </p>
 * @date 2020/4/1
 * @see com.tyw.document
 */
@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
@Data
public class UserDocument {

	@Id
	private String id;

	@Field(type = FieldType.Keyword)
	private String userName;

}
