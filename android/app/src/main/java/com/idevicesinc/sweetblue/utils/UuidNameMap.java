package com.idevicesinc.sweetblue.utils;

import com.idevicesinc.sweetblue.BleManagerConfig;

import java.util.UUID;

/**
 * Provide an implementation to {@link BleManagerConfig#uuidNameMaps}.
 * 
 * @see BleManagerConfig#uuidNameMaps
 */
public interface UuidNameMap
{
	/**
	 * Returns the name of the {@link UUID} to be used for logging/debugging purposes, for example "BATTERY_LEVEL".
	 */
	String getUuidName(String uuid);
}
