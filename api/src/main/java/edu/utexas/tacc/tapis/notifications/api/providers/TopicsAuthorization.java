package edu.utexas.tacc.tapis.notifications.api.providers;

import edu.utexas.tacc.tapis.notifications.lib.models.TopicPermissionsEnum;

import javax.annotation.Priority;
import javax.ws.rs.NameBinding;
import javax.ws.rs.Priorities;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for doing authz for files. Place it on a method like such:
 * @GET
 * @FileOpsAuthorization(permsRequired = FilePermissionsEnum.READ)
 * public Response getSomething() {
 *  yada...yada..
 * }
 */
@Documented
@NameBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Priority(Priorities.AUTHORIZATION)
public @interface TopicsAuthorization {

    TopicPermissionsEnum permsRequired() default TopicPermissionsEnum.READ;

}