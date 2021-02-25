/*
 * Copyright 2020 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.data.client.mocks;

import com.ibm.watson.data.client.tests.*;
import org.mockserver.client.MockServerClient;
import org.mockserver.client.initialize.PluginExpectationInitializer;

/**
 * Setup a mock server to act as a Cloud Pak for Data endpoint against which we can do some thorough testing.
 */
public class MockServerExpectations implements PluginExpectationInitializer {

    /**
     * Setup the expectations we will need to respond to various tests.
     * @param mockServerClient the client against which to set the expectations
     */
    @Override
    public void initializeExpectations(MockServerClient mockServerClient) {

        new AccountManagementTest().init(mockServerClient);
        new AssetAttachmentsTest().init(mockServerClient);
        new AssetFilesTest().init(mockServerClient);
        new AssetsTest().init(mockServerClient);
        new AssetTrashTest().init(mockServerClient);
        new AssetTypesTest().init(mockServerClient);
        new AuthorizationTest().init(mockServerClient);
        new BusinessTermsTest().init(mockServerClient);
        new CatalogTest().init(mockServerClient);
        new CatalogMembersTest().init(mockServerClient);
        new CategoriesTest().init(mockServerClient);
        new ClassificationsTest().init(mockServerClient);
        new ConnectionsTest().init(mockServerClient);
        new DataAssetsTest().init(mockServerClient);
        new DataClassesTest().init(mockServerClient);
        new DataProtectionRulesTest().init(mockServerClient);
        new DatasourceTypesTest().init(mockServerClient);
        new DeploymentsTest().init(mockServerClient);
        new GovernanceArtifactTypesTest().init(mockServerClient);
        new JobsTest().init(mockServerClient);
        new JobRunsTest().init(mockServerClient);
        new ModelsTest().init(mockServerClient);
        new MonitorTest().init(mockServerClient);
        new PoliciesTest().init(mockServerClient);
        new ProjectsMembersTest().init(mockServerClient);
        new ProjectsTest().init(mockServerClient);
        new ProjectsIntegrationsTest().init(mockServerClient);
        new ProjectsSettingsTest().init(mockServerClient);
        new ProjectsTokensTest().init(mockServerClient);
        new ReferenceDataSetsTest().init(mockServerClient);
        new RoleManagementTest().init(mockServerClient);
        new RulesTest().init(mockServerClient);
        new SearchTest().init(mockServerClient);
        new SpacesMembersTest().init(mockServerClient);
        new SpacesTest().init(mockServerClient);
        new TransactionalProjectsTest().init(mockServerClient);
        new UserManagementTest().init(mockServerClient);
        new WorkflowsTest().init(mockServerClient);
        new WorkflowUserTasksTest().init(mockServerClient);

    }

}