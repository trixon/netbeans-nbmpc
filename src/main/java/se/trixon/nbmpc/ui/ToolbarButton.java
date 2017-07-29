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
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JButton;
import org.openide.util.actions.Presenter;
import se.trixon.almond.util.icons.IconColor;
import se.trixon.almond.util.icons.material.MaterialIcon;

public abstract class ToolbarButton extends AbstractAction implements Presenter.Toolbar {

    protected JButton mButton;
    protected IconColor mIconColor = IconColor.WHITE;
    protected MaterialIcon.IconGetter mIconGetter;

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

    private void init() {
        mButton = new JButton();
        mButton.addActionListener(this);
    }

    protected void updateIcon() {
        mButton.setIcon(mIconGetter.get(22, mIconColor));
    }
}
