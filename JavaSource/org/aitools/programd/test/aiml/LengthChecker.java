package org.aitools.programd.test.aiml;

import org.aitools.programd.util.DeveloperError;

/**
 * Tests whether a given input has an expected length.
 * 
 * @author Albertas Mickensas
 * @author <a href="noel@aitools.org">Noel Bush</a>
 */
public class LengthChecker extends Checker
{
    private int expectedLength = -1;

    /**
     * Creates a new LengthChecker with the given length.
     * 
     * @param length the length to check for
     */
    public LengthChecker(String length)
    {
        try
        {
            this.expectedLength = Integer.parseInt(length);
        }
        catch (NumberFormatException e)
        {
            throw new DeveloperError("The schema allowed a non-integer value for LengthChecker!", e);
        }
    }

    /**
     * Tests whether the given input has the expected length.
     * 
     * @param input the input to test
     * @return whether the given input has the expected length
     * @see org.aitools.programd.test.aiml.Checker#test(java.lang.String)
     */
    @Override
    public boolean test(String input)
    {
        if (this.expectedLength != -1)
        {
            if (input.trim().length() == this.expectedLength)
            {
                return true;
            }
            // otherwise...
            return false;
        }
        // otherwise...
        return false;
    }

    /**
     * @see org.aitools.programd.test.aiml.Checker#getContent()
     */
    @Override
    public String getContent()
    {
        return "" + this.expectedLength;
    }

    /**
     * @see org.aitools.programd.test.aiml.Checker#getTagName()
     */
    @Override
    public String getTagName()
    {
        return Checker.TAG_EXPECTED_LENGTH;
    }
}
