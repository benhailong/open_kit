package cc.openkit.kitIsNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 验证是不是身份证
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface KitIsLong {
    // 最短长度，如果为 -1 标识不设置
    int min() default -1;
    // 最大长度，如果为 -1 标识不设置
    int max() default -1;
    String value() default "长度不符合要求";
}
