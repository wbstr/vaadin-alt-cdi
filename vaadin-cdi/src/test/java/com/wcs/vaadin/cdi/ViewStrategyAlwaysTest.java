/*
 * Copyright 2017 kumm.
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
 *
 */

package com.wcs.vaadin.cdi;

import com.wcs.vaadin.cdi.uis.ViewStrategyUI;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;

public class ViewStrategyAlwaysTest extends AbstractViewStrategyTest {

    @Deployment(testable = false)
    public static WebArchive deployment() {
        return ArchiveProvider.createWebArchive("viewStrategyViewName", ViewStrategyUI.class);
    }

    @Test
    public void testNavigationToSameViewAndParametersCreatesNewContext() throws Exception {
        assertToTestedViewContextCreated(
                ViewStrategyUI.P1ALWAYS_NAV_BTN_ID,
                ViewStrategyUI.P1ALWAYS_NAV_BTN_ID,
                ",byalways:p1",
                ",byalways:p1"
        );
    }

    @Test
    public void testNavigationToSameViewNoParametersCreatesNewContext() throws Exception {
        assertToTestedViewContextCreated(
                ViewStrategyUI.ALWAYS_NAV_BTN_ID,
                ViewStrategyUI.ALWAYS_NAV_BTN_ID,
                ",byalways:",
                ",byalways:"
        );
    }

    @Test
    public void testNavigationToSameViewDifferentParametersCreatesNewContext() throws Exception {
        assertToTestedViewContextCreated(
                ViewStrategyUI.P1ALWAYS_NAV_BTN_ID,
                ViewStrategyUI.P2ALWAYS_NAV_BTN_ID,
                ",byalways:p1",
                ",byalways:p2"
        );
    }

    @Test
    public void testNavigationToOtherViewCreatesNewContext() throws Exception {
        assertToOtherViewContextCreated(
                ViewStrategyUI.ALWAYS_NAV_BTN_ID,
                ",byalways:"
        );
    }

    @Override
    protected String getTestedViewDestroyCounter() {
        return ViewStrategyUI.ByAlwaysView.DESTROY_COUNT;
    }

    @Override
    protected String getTestedViewContructCounter() {
        return ViewStrategyUI.ByAlwaysView.CONSTRUCT_COUNT;
    }
}
