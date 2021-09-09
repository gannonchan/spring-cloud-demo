package com.gannon.cloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
//jpa的懒加载对象自己为填加了一些属性，(“hibernateLazyInitializer”,“handler”,“fieldHandler”),
//这些属性会影响到SpringMVC返回Json(因为返回时有个内省机制,因为你需要序列化对象有一个属性是一类类型,
//而你使用了Hibernate的延迟加载所以这里是个Hibernate的代理对象。该代理对象有些属性不能被序列化所以会报错。
//加入此注解忽略该属性，或重写消息转换器
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String gender;
    private String age;
}
