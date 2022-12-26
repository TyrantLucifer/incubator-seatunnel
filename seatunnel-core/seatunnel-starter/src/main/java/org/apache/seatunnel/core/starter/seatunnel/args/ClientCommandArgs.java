/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.core.starter.seatunnel.args;

import org.apache.seatunnel.common.config.DeployMode;
import org.apache.seatunnel.core.starter.command.AbstractCommandArgs;
import org.apache.seatunnel.engine.common.runtime.ExecutionMode;

import com.beust.jcommander.Parameter;

public class ClientCommandArgs extends AbstractCommandArgs {
    @Parameter(names = {"-m", "--master"},
        description = "SeaTunnel job submit master, support [client, cluster]",
        converter = ExecutionModeConverter.class)
    private ExecutionMode executionMode = ExecutionMode.CLUSTER;

    @Parameter(names = {"-cn", "--cluster"},
        description = "The name of cluster")
    private String clusterName = "seatunnel_default_cluster";

    @Parameter(names = {"-j", "--job-id"},
        description = "Get job status by JobId")
    private String jobId;

    @Parameter(names = {"-can", "--cancel-job"},
        description = "Cancel job by JobId")
    private String cancelJobId;

    @Parameter(names = {"--metrics"},
        description = "Get job metrics by JobId")
    private String metricsJobId;

    @Parameter(names = {"-l", "--list"},
        description = "list job status")
    private boolean listJob = false;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public ExecutionMode getExecutionMode() {
        return executionMode;
    }

    public void setExecutionMode(ExecutionMode executionMode) {
        this.executionMode = executionMode;
    }

    public String getJobId() {
        return jobId;
    }

    public String getCancelJobId() {
        return cancelJobId;
    }

    public String getMetricsJobId() {
        return metricsJobId;
    }

    public boolean isListJob(){
        return listJob;
    }

    public DeployMode getDeployMode() {
        return DeployMode.CLIENT;
    }
}
