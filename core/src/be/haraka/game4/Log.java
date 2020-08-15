package be.haraka.game4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Logging class, has a prefix defined upon intialisation such as a printed message looks like:
 *
 * e.g.
 * [Network] 10/08/2019 - Connected to client at port 192.168.0.1
 *
 * A nester class {@link LogMessage} is contained. Each logmessage represents a string message
 * and a date specified upon object creation.
 *
 */

public class Log {

    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

    private List<LogMessage> messages = new ArrayList<>();

    // Used to determine when the log has been created
    private Date creationDate = new Date();

    private String logPrefix; // AKA. "[Network]"

    public Log(String prefix) {
        logPrefix = prefix;
    }

    /**
     * Adds a new message to the list and prints it.
     * @param message, the new {@link LogMessage} infos.
     */
    public void addMessage(String message) {
        LogMessage newMessage = new LogMessage(message);
        messages.add(newMessage);
        System.out.println(logPrefix+" "+newMessage);
    }


    /**
     * Adds a new message to the list and prints it.
     * @param message, the new {@link LogMessage} infos.
     * @param mute, if set as true, then the message will
     *              not be printed.
     */
    public void addMessage(String message, boolean mute) {
        LogMessage newMessage = new LogMessage(message);
        messages.add(newMessage);
        if (!mute) {
            System.out.println(logPrefix+" "+newMessage);
        }
    }

    public class LogMessage {

        private String message;
        private Date time;

        // By default always 1 but maybe will be changed later.
        private int priority = 1;

        public LogMessage(String message) {
            this.message = message;
            this.time = new Date();
        }

        @Override
        public String toString() {
            return dateFormat.format(time)+" "+message;
        }
    }
}
