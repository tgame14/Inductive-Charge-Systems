package com.tgame.inductivecharge;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author tgame14
 * @since 29/04/14
 */
public class Settings
{
	public static final String ID = "inductivechargesystems";
	public static final String NAME = "Inductive Charge Systems";
	public static final String CHANNEL = ID;
	public static final String VERSION = "@VERSION@";
	public static final String AUTHOR = "@AUTHOR@";
    public static final String DOMAIN = "com.tgame.inductivecharge";

	public static final String RESOURCE_LOCATION = ID + ":";

	public static final Logger LOGGER = LogManager.getLogger(ID);
	public static Configuration CONFIGURATION;



}
