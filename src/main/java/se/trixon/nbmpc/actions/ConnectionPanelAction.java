/*
 * Copyright 2017 Patrik Karlsson.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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
package se.trixon.nbmpc.actions;

import java.awt.event.ActionEvent;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.nbmpc.ui.ConnectionPanel;
import se.trixon.nbmpc.ui.ToolbarButton;

@ActionID(category = "nbmpc", id = "se.trixon.nbmpc.actions.ConnectionPanel")
@ActionRegistration(lazy = false, displayName = "NOT-USED")
@ActionReference(path = "Toolbars/nbmpc", position = 0)

@Messages("CTL_ConnectionPanelAction=Connection")
public final class ConnectionPanelAction extends ToolbarButton {

    public ConnectionPanelAction() {
        initPopup(new ConnectionPanel());
        setTitle(Bundle.CTL_ConnectionPanelAction());
        setMaterialIcon(MaterialIcon._Hardware.COMPUTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        showPopup();
    }
}
