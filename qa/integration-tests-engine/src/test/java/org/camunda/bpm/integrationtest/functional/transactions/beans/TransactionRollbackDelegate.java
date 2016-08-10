/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.integrationtest.functional.transactions.beans;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
public class TransactionRollbackDelegate implements JavaDelegate {

  @Inject
  private UserTransaction utx;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    // simulate a failure that triggers the transaction rollback
    utx.setRollbackOnly();
  }

}