/*
 * Copyright © 2013-2018 camunda services GmbH and various authors (info@camunda.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.cdi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.spi.PassivationCapable;

/**
 * Declare a bean to be BusinessProcessScoped. Instances of
 * BusinessProcessScoped beans are stored as process variables in a
 * ProcessInstance.
 * <p />
 * Note: BusinessProcessScoped beans need to be {@link PassivationCapable}.
 * <p />
 * Note: BusinessProcessScoped is not capable of managing local process variables,
 * and there is currently also no respective other implementation for that. Please use
 * {@link org.camunda.bpm.engine.cdi.BusinessProcess#setVariableLocal(String, Object)}
 * and {@link org.camunda.bpm.engine.cdi.BusinessProcess#getVariableLocal(String)}
 * or an injected Map of local process variables instead.
 * <p />
 * If no ProcessInstance is currently managed, instances of
 * {@link BusinessProcessScoped} beans are temporarily stored in a local scope
 * (I.e. the Conversation or the Request, depending on the context, see javadoc
 * on {@link ConversationScoped} and {@link RequestScoped} to find out when
 * either context is active). If this scope is later associated with a business
 * process instance, the bean instances are flushed to the ProcessInstance.
 * <p />
 * Example:
 * <pre>
 * {@code @BusinessProcessScoped}
 * public class Authorization implements Serializable {
 *    ...
 * }
 * </pre>
 * 
 * @author Daniel Meyer
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface BusinessProcessScoped {

}
