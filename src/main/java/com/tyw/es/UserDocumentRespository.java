package com.tyw.es;

import com.tyw.document.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author tboss
 * <p>
 * Description:定义 UserDocumentRespository 接口
 * </p>
 * @date 2020/4/1
 * @see com.tyw.es
 */
public interface UserDocumentRespository extends ElasticsearchRepository<UserDocument,String> {

}
