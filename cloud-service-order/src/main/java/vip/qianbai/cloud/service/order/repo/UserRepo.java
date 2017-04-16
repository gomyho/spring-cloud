package vip.qianbai.cloud.service.order.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vip.qianbai.cloud.service.order.entity.UserEntity;


/** 
 * @date    2017年4月12日 <br/> 
 * @author   陈小峰
 * @since    JDK 1.8
 */
@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{

	@Query("from #{#entityName} where userName = ?1")
	UserEntity findByName(String name);
}
