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
package org.camunda.bpm.engine.test.bpmn.event;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.impl.test.PluggableProcessEngineTestCase;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.test.Deployment;

public class IntermediateNoneEventTest extends PluggableProcessEngineTestCase {
  
  private static boolean listenerExcecuted = false;
  
  public static class MyExecutionListener implements ExecutionListener {
    public void notify(DelegateExecution execution) throws Exception {
      listenerExcecuted = true;
    }    
  }

  @Deployment
  public void testIntermediateNoneTimerEvent() throws Exception {    
    assertFalse(listenerExcecuted);    
    ProcessInstance pi = runtimeService.startProcessInstanceByKey("intermediateNoneEventExample");
    assertProcessEnded(pi.getProcessInstanceId());
    assertTrue(listenerExcecuted);    
  }


}