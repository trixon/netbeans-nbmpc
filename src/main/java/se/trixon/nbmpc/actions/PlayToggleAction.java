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
import org.bff.javampd.player.Player.Status;
import org.bff.javampd.player.PlayerChangeEvent;
import org.bff.javampd.player.PlayerChangeListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle;
import se.trixon.almond.util.icons.material.MaterialIcon;
import se.trixon.nbmpc.ui.ToolbarButton;

@ActionID(category = "nbmpc", id = "se.trixon.nbmpc.actions.PlayToggleAction")
@ActionRegistration(lazy = false, displayName = "NOT-USED")
@ActionReference(path = "Toolbars/nbmpc", position = 11)

@NbBundle.Messages("CTL_PlayToggleAction=Play/pause")
public final class PlayToggleAction extends ToolbarButton {

    public PlayToggleAction() {
        setTitle(Bundle.CTL_PlayToggleAction());
        setMaterialIcon(MaterialIcon._Av.PLAY_CIRCLE_OUTLINE);

        mPlayer.addPlayerChangeListener(new PlayerChangeListener() {
            @Override
            public void playerChanged(PlayerChangeEvent pce) {
                if (pce.getEvent() == PlayerChangeEvent.Event.PLAYER_STOPPED || pce.getEvent() == PlayerChangeEvent.Event.PLAYER_PAUSED) {
                    setMaterialIcon(MaterialIcon._Av.PLAY_CIRCLE_OUTLINE);
                } else {
                    setMaterialIcon(MaterialIcon._Av.PAUSE_CIRCLE_OUTLINE);
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Status playerStatus = mPlayer.getStatus();

        if (playerStatus == Status.STATUS_STOPPED || playerStatus == Status.STATUS_PAUSED) {
            mPlayer.play();
        } else {
            mPlayer.pause();
        }
    }
}
