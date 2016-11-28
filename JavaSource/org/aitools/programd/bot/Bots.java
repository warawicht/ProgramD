/*
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version. You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */

package org.aitools.programd.bot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.aitools.programd.util.DeveloperError;

/**
 * Contains all descriptions of bots.
 * 
 * @author <a href="mailto:noel@aitools.org">Noel Bush</a>
 * @since 4.1.5
 * @version 4.5
 */
public class Bots
{
    /** The map of bot ids to bots. */
    private Map<String, Bot> botMap;

    /**
     * Creates a new <code>Bots</code>.
     */
    public Bots()
    {
        this.botMap = Collections.checkedMap(new HashMap<String, Bot>(), String.class, Bot.class);
    }

    /**
     * Returns whether the loaded bots include one with the given id.
     * 
     * @param botid the botid to look for
     * @return whether the loaded bots include one with the given id
     */
    public boolean include(String botid)
    {
        return this.botMap.containsKey(botid);
    }

    /**
     * Adds the given bot with the given id. No check is made to see whether a
     * bot is already loaded with the given id!
     * 
     * @param botid the id to use for the bot
     * @param bot the bot to add
     */
    public void addBot(String botid, Bot bot)
    {
        this.botMap.put(botid, bot);
    }

    /**
     * Returns the bot with the given id.
     * 
     * @param botid the id of the bot to return
     * @return the bot with the given id
     */
    public Bot getBot(String botid)
    {
        Bot wanted;
        try
        {
            wanted = this.botMap.get(botid);
        }
        catch (ClassCastException e)
        {
            throw new DeveloperError("Something other than a Bot stored in Bots!", e);
        }
        if (wanted == null)
        {
            throw new DeveloperError("Tried to get unknown bot \"" + botid + "\".", new NullPointerException());
        }
        return wanted;
    }

    /**
     * Returns any bot (probably the last one loaded).
     * 
     * @return any bot (probably the last one loaded)
     */
    public Bot getABot()
    {
        if (this.botMap.size() > 0)
        {
            return this.botMap.values().iterator().next();
        }
        return null;
    }

    /**
     * Returns the number of bots (the size)
     * 
     * @return the number of bots (the size)
     */
    public int getCount()
    {
        return this.botMap.size();
    }

    /**
     * Returns a nicely-formatted list of the bots.
     * 
     * @return a nicely-formatted list of the bots
     */
    public String getNiceList()
    {
        if (this.botMap.size() == 0)
        {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String botName : this.botMap.keySet())
        {
            if (result.length() > 0)
            {
                result.append(' ');
            }
            result.append(botName);
        }
        return result.toString();
    }

    /**
     * Returns the IDs (the key set)
     * 
     * @return the IDs (the key set)
     */
    public Set<String> getIDs()
    {
        return this.botMap.keySet();
    }

    /**
     * Returns an iterator over the key set
     * 
     * @return an iterator over the key set
     */
    public Iterator<String> keysIterator()
    {
        return this.botMap.keySet().iterator();
    }

    /**
     * Returns whether any bots have loaded the given file(name).
     * 
     * @param filename
     * @return whether any bots have loaded the given file(name)
     */
    public boolean haveLoaded(String filename)
    {
        for (Bot bot : this.botMap.values())
        {
            if (bot.hasLoaded(filename))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes the indicated bot.
     * 
     * @param id
     */
    public void removeBot(String id)
    {
        this.botMap.remove(id);
    }
}