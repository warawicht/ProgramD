/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.interfaces.shell;

/**
 * Prints a list of active bots to the shell console.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 * @since 4.5
 */
public class BotListCommand extends ShellCommand
{
    /** Shell command. */
    public static final String COMMAND_STRING = "/bots";
    
    /** Argument template. */
    public static final String ARGUMENT_TEMPLATE = "";
    
    /** Shell help line. */
    private static final String HELP_LINE = "lists loaded bots";

    /**
     * Creates a new BotListCommand.
     */
    public BotListCommand()
    {
        super(COMMAND_STRING, ARGUMENT_TEMPLATE, HELP_LINE);
    }

    /**
     * @see org.aitools.programd.interfaces.shell.ShellCommand#handles(java.lang.String)
     */
    @Override
    public boolean handles(String commandLine)
    {
        return commandLine.toLowerCase().equals(COMMAND_STRING);
    }

    /**
     * Prints a list of active bots to the shell console.
     * @see org.aitools.programd.interfaces.shell.ShellCommand#handle(java.lang.String, org.aitools.programd.interfaces.shell.Shell)
     */
    @Override
    public void handle(@SuppressWarnings("unused") String commandLine, Shell shell)
    {
        shell.showMessage("Active bots: " + shell.getBots().getNiceList());
    }
}
