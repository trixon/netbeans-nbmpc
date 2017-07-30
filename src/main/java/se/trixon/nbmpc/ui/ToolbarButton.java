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
package se.trixon.nbmpc.ui;

/**
 *
 * @author Patrik Karlsson
 */
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import org.bff.javampd.player.Player;
import org.openide.util.actions.Presenter;
import se.trixon.almond.util.icons.IconColor;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.nbmpc.Mpc;

public abstract class ToolbarButton extends AbstractAction implements Presenter.Toolbar {

    private static final int ICON_SIZE = 22;
    private MaterialIcon.IconGetter mMaterialIcon;
    private JButton mButton;
    protected final Mpc mMpc = Mpc.getInstance();
    private JPanel mPanel;
    private JPopupMenu mPopupMenu = new JPopupMenu();
    protected Player mPlayer = mMpc.getMpd().getPlayer();

    public ToolbarButton() {
        init();
    }

    public ToolbarButton(String name) {
        super(name);
        init();
    }

    public ToolbarButton(String name, Icon icon) {
        super(name, icon);
        init();
    }

    public JButton getButton() {
        return mButton;
    }

    @Override
    public Component getToolbarPresenter() {
        return mButton;
    }

    public void setMaterialIcon(MaterialIcon.IconGetter materialIcon) {
        mMaterialIcon = materialIcon;
        mButton.setIcon(mMaterialIcon.get(ICON_SIZE, IconColor.getForBackground(mButton.getBackground())));
    }

    private void init() {
        mButton = new JButton();
        mButton.addActionListener(this);
        mButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                showPopup();
            }
        });
    }

    protected void initPopup(JPanel panel) {
        mPanel = panel;
        mPopupMenu.add(mPanel);
        mPopupMenu.show(null, Integer.MAX_VALUE, Integer.MAX_VALUE);
        mPopupMenu.setVisible(false);
    }

    protected void setTitle(String title) {
        putValue(NAME, title);
        if (mPanel == null) {
            mButton.setToolTipText(title);
        }
    }

    protected void showPopup() {
        if (mPanel != null) {
            mPopupMenu.show(mButton, -(mPanel.getWidth() - mButton.getWidth()) / 2, mButton.getHeight());
        } else if (mButton.getParent() instanceof JToolBar) {
            mPopupMenu.show(mButton, 0, 0);
        }
    }
}
