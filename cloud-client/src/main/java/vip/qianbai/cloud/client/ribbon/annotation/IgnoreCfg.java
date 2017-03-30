package vip.qianbai.cloud.client.ribbon.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 
 * ribbon feign configuration flag 
 * @date    2017年2月22日 <br/> 
 * @author   陈小峰
 * @since    JDK 7
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreCfg {

}
