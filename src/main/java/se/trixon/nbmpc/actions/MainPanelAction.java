/*
 * Copyright 2017 pata.
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
import static javax.swing.Action.NAME;
import javax.swing.JPopupMenu;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.nbmpc.ui.MainPanel;
import se.trixon.nbmpc.ui.ToolbarButton;

@ActionID(category = "nbmpc", id = "se.trixon.nbmpc.actions.MainPanelAction")
@ActionRegistration(lazy = false, displayName = "NOT-USED")
@ActionReference(path = "Toolbars/nbmpc", position = 99)

@Messages("CTL_MainPanelAction=Show panel")
public final class MainPanelAction extends ToolbarButton {

    private final MainPanel mPanel;
    private final JPopupMenu mPopupMenu = new JPopupMenu();

    public MainPanelAction() {
        putValue(NAME, Bundle.CTL_MainPanelAction());
        mIconGetter = MaterialIcon._Navigation.EXPAND_MORE;
        updateIcon();
        mPanel = new MainPanel();
        mPopupMenu.add(mPanel);
        mPopupMenu.addPopupMenuListener(new PopupMenuListener() {
            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                mIconGetter = MaterialIcon._Navigation.EXPAND_MORE;
                updateIcon();
            }

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                mIconGetter = MaterialIcon._Navigation.EXPAND_LESS;
                updateIcon();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mPopupMenu.show(mButton, -(mPanel.getWidth() - mButton.getWidth()) / 2, mButton.getHeight());
    }
}
