package com.idevicesinc.sweetblue.utils;

import com.idevicesinc.sweetblue.BleManagerConfig;
import com.idevicesinc.sweetblue.annotations.Extendable;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Convenience implementation of {@link UuidNameMap} that takes a {@link Class} object
 * and through reflection attempts to parse out all the static UUID members, for example
 * on {@link Uuids}.
 * 
 * Provide an instance to {@link BleManagerConfig#uuidNameMaps} if desired.
 * 
 * @see BleManagerConfig#uuidNameMaps
 * @see BasicUuidNameMap
 */
@Extendable
public class ReflectionUuidNameMap implements UuidNameMap
{
	private final HashMap<String, String> m_dict = new HashMap<String, String>();
	
	public ReflectionUuidNameMap(Class<?> classWithStaticUuids)
	{
		for( Field field : classWithStaticUuids.getFields() )
		{
			String uuid = Utils_Reflection.fieldStringValue(field);
			
			m_dict.put(uuid, field.getName());
		}
	}

	@Override
	public String getUuidName(String uuid)
	{
		uuid = uuid.toLowerCase();
		return m_dict.get(uuid);
	}
}
