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
package se.trixon.nbmpc;

import java.util.Date;
import org.bff.javampd.server.MPD;
import org.netbeans.api.io.IOProvider;
import org.netbeans.api.io.InputOutput;
import org.netbeans.api.io.OutputWriter;

/**
 *
 * @author Patrik Karlsson
 */
public class Mpc {

    public static OutputWriter err;
    private static InputOutput io;
    public static OutputWriter out;
    private static boolean useTimestamps = true;
    private MPD mMpd = new MPD.Builder().build();

    static {
        io = IOProvider.getDefault().getIO("nbmpc", false);
        out = io.getOut();
        err = io.getErr();

    }

    public static void errln(String aMessage) {
        printDate(err);
        err.println(aMessage);
        err.flush();
    }

    public static Mpc getInstance() {
        return Holder.INSTANCE;
    }

    public static void outln(String aMessage) {
        printDate(out);
        out.println(aMessage);
        out.flush();
    }

    public static void outlnEvent(String aMessage) {
        printDate(out);
        out.println(aMessage);
        out.flush();
    }

    private static void printDate(OutputWriter anOutputWriter) {
        Date date = new Date();
        if (useTimestamps) {
            anOutputWriter.print(date + ": ");
        }
    }

    private Mpc() {
    }

    public MPD getMpd() {
        return mMpd;
    }

    private static class Holder {

        private static final Mpc INSTANCE = new Mpc();
    }
}
