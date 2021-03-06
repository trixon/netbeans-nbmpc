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

import javax.swing.JButton;
import org.bff.javampd.player.Player;
import org.bff.javampd.player.VolumeChangeEvent;
import org.bff.javampd.player.VolumeChangeListener;
import se.trixon.nbmpc.Mpc;
import se.trixon.nbmpc.actions.VolumeMuteAction;
import se.trixon.nbmpc.actions.VolumeUnMuteAction;

/**
 *
 * @author Patrik Karlsson
 */
public class VolumePanel extends javax.swing.JPanel {

    Mpc mpc = Mpc.getInstance();
    protected Player mPlayer = mpc.getMpd().getPlayer();

    /**
     * Creates new form VolumePanel
     */
    public VolumePanel() {
        initComponents();

        mPlayer.addVolumeChangeListener(new VolumeChangeListener() {
            @Override
            public void volumeChanged(VolumeChangeEvent event) {
                slider.setValue(event.getVolume());
            }
        });

        VolumeMuteAction muteAction = new VolumeMuteAction();
        JButton muteButton = muteAction.getButton();

        VolumeUnMuteAction unmuteAction = new VolumeUnMuteAction();
        JButton unmuteButton = unmuteAction.getButton();

        buttonPanel.add(muteButton);
        buttonPanel.add(unmuteButton);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        slider = new javax.swing.JSlider();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setOpaque(false);
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        buttonPanel.setLayout(new java.awt.GridLayout(1, 2));
        add(buttonPanel);

        slider.setOrientation(javax.swing.JSlider.VERTICAL);
        slider.setAlignmentY(1.0F);
        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });
        add(slider);
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        // TODO add your handling code here:
        mpc.getMpd().getPlayer().setVolume(slider.getValue());
    }//GEN-LAST:event_sliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}
