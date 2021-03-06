/**
 *  Copyright 2005-2015 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package io.fabric8.openshift.commands;

import com.openshift.client.IDomain;
import com.openshift.client.IOpenShiftConnection;
import io.fabric8.utils.TablePrinter;
import org.apache.felix.gogo.commands.Command;

@Command(name = "domain-list", scope = "openshift", description = "Lists available openshift domains")
public class DomainListAction extends OpenshiftCommandSupport {

    @Override
    protected Object doExecute() throws Exception {
        IOpenShiftConnection connection = getOrCreateConnection();

        TablePrinter printer = new TablePrinter();
        printer.column("id");

        for (IDomain domain :connection.getDomains()){
            printer.row(domain.getId());
        }
        printer.print();

        return null;
    }
}
