/*
 * Copyright 2014 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package azkaban.alert;

import azkaban.executor.ExecutableFlow;
import azkaban.executor.Executor;
import azkaban.executor.ExecutorManagerException;
import azkaban.sla.SlaOption;
import java.util.List;

public interface Alerter {

  void alertOnSuccess(ExecutableFlow exflow) throws Exception;

  void alertOnError(ExecutableFlow exflow, String... extraReasons) throws Exception;

  void alertOnFirstError(ExecutableFlow exflow) throws Exception;

  void alertOnSla(SlaOption slaOption, String slaMessage) throws Exception;

  void alertOnFailedUpdate(Executor executor, List<ExecutableFlow> executions,
      ExecutorManagerException e);

  void alertOnFailedExecutorHealthCheck(Executor executor,
      List<ExecutableFlow> executions,
      ExecutorManagerException e, List<String> alertEmails);

  String getAzkabanURL();
}
